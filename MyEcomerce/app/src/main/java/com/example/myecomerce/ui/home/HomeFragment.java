package com.example.myecomerce.ui.home;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myecomerce.Login1.Profile;
import com.example.myecomerce.R;
import com.example.myecomerce.activities.MainActivity;
import com.example.myecomerce.adapters.HomeAdapter;
import com.example.myecomerce.adapters.PopularAdapters;
import com.example.myecomerce.adapters.RecommenededAdapter;
import com.example.myecomerce.adapters.ViewAllAdapter;
import com.example.myecomerce.databinding.FragmentHomeBinding;
import com.example.myecomerce.models.HomeCategory;
import com.example.myecomerce.models.PopularModel;
import com.example.myecomerce.models.RecommendedModel;
import com.example.myecomerce.models.ViewAllModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {


    ScrollView scrollView;
    ProgressBar progressBar;


    RecyclerView popularRec, homeCateRec, RecommendedRec;

    FirebaseFirestore db;


    ///Search View
    EditText search_box;
    private List<ViewAllModel> viewAllModelList;
    private RecyclerView recyclerViewSearch;
    private ViewAllAdapter viewAllAdapter;



    //popuplar items
    List<PopularModel> popularModelList;
    PopularAdapters popularAdapters;

    //Home Category
    List<HomeCategory> categoryList;
    HomeAdapter homeAdapter;

    //Recommended
    List<RecommendedModel>recommendedModelList;
    RecommenededAdapter recommenededAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);

        db= FirebaseFirestore.getInstance();

        popularRec = root.findViewById(R.id.pop_rec);
        homeCateRec = root.findViewById(R.id.explore_rec);
        RecommendedRec = root.findViewById(R.id.recommended_rec);

        scrollView = root.findViewById(R.id.scroll_View);
        progressBar = root.findViewById(R.id.progressbar);


        progressBar.setVisibility(View.VISIBLE);
        scrollView.setVisibility(View.GONE);




        //Popular items
        popularRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        popularModelList = new ArrayList<>();
        popularAdapters = new PopularAdapters(getActivity(),popularModelList);

        popularRec.setAdapter(popularAdapters);



        db.collection("PopularProducts")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                PopularModel popularModel = document.toObject(PopularModel.class);

                                popularModelList.add(popularModel);
                                popularAdapters.notifyDataSetChanged();


                                progressBar.setVisibility(View.GONE);
                                scrollView.setVisibility(View.VISIBLE);

                            }
                        } else {
                            Toast.makeText(getActivity(),"Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });



        //Home Category
        homeCateRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        categoryList = new ArrayList<>();
        homeAdapter = new HomeAdapter(getActivity(),categoryList);
        homeCateRec.setAdapter(homeAdapter);



        db.collection("HomeCategory")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                HomeCategory homeCategory = document.toObject(HomeCategory.class);

                                categoryList.add(homeCategory);
                                homeAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(),"Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });





        //Recommended
        RecommendedRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        recommendedModelList = new ArrayList<>();
        recommenededAdapter = new RecommenededAdapter(getActivity(),recommendedModelList);
        RecommendedRec.setAdapter(recommenededAdapter);



        db.collection("Recommended")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                RecommendedModel recommendedModel = document.toObject(RecommendedModel.class);

                                recommendedModelList.add(recommendedModel);
                                recommenededAdapter.notifyDataSetChanged();

                            }
                        } else {
                            Toast.makeText(getActivity(),"Error"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });



        ///Search View


        viewAllModelList =new ArrayList<>();
        viewAllAdapter = new ViewAllAdapter(getContext(),viewAllModelList);
        recyclerViewSearch = root.findViewById(R.id.search_rec);
        search_box = root.findViewById(R.id.search_box);
        recyclerViewSearch.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewSearch.setAdapter(viewAllAdapter);
        recyclerViewSearch.setHasFixedSize(true);
        search_box.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().isEmpty()){
                    viewAllModelList.clear();
                    viewAllAdapter.notifyDataSetChanged();
                }else {
                    searchProduct(s.toString());
                }

            }
        });



        /*------------------------------------------Bottom Navigation View----------------------------------------------------------------------*/
        BottomNavigationView bottomNavigationView= root.findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.Profile:
                        startActivity(new Intent(getActivity(), Profile.class));
                        return true;
                    case R.id.home:
                        return true;
                        /*
                    case R.id.about:
                        startActivity(new Intent(getApplicationContext(), About.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.feedback:
                        startActivity(new Intent(getApplicationContext(), ReportProblemActivity.class));
                        overridePendingTransition(0,0);
                        return true;

                         */
                }
                return false;
            }
        });
        /*------------------------------------------Bottom Navigation View----------------------------------------------------------------------*/





        return root;
    }

    private void searchProduct(String type) {

        if (!type.isEmpty())
        {
            db.collection("AllProducts").whereEqualTo("type",type).get()
                    .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if (task.isSuccessful() && task.getResult() != null){

                                viewAllModelList.clear();
                                viewAllAdapter.notifyDataSetChanged();
                                for (DocumentSnapshot doc: task.getResult().getDocuments())
                                {
                                    ViewAllModel viewAllModel = doc.toObject(ViewAllModel.class);
                                    viewAllModelList.add(viewAllModel);
                                    viewAllAdapter.notifyDataSetChanged();
                                }


                            }
                        }
                    });
        }


    }


}