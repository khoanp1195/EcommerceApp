package com.example.myecomerce;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.myecomerce.adapters.MyCartAdapter;
import com.example.myecomerce.models.MyCartModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;


public class MyOrdersFragment extends Fragment {



    FirebaseFirestore db;
    FirebaseAuth auth;

    TextView overTotalAmount;


    RecyclerView recyclerView;
    MyCartAdapter cartAdapter;

    List<MyCartModel> cartModelList;

    ProgressBar progressBar;



    public MyOrdersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_my_orders, container, false);


        progressBar = root.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
      //  buynow = root.findViewById(R.id.buy_now);

        db = FirebaseFirestore.getInstance();
        auth = FirebaseAuth.getInstance();
        recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setVisibility(View.GONE);

        overTotalAmount = root.findViewById(R.id.totalPrice);



        cartModelList= new ArrayList<>();

        cartAdapter = new MyCartAdapter(getActivity(),cartModelList);

        recyclerView.setAdapter(cartAdapter);


        db.collection("CurrentUser").document(auth.getCurrentUser().getUid())
                .collection("MyOrder").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    for (DocumentSnapshot documentSnapshot : task.getResult().getDocuments()){

                        String documentId = documentSnapshot.getId();



                        MyCartModel cartModel = documentSnapshot.toObject(MyCartModel.class);
                        cartModel.setDocumentId(documentId);
                        cartModelList.add(cartModel);
                        cartAdapter.notifyDataSetChanged();
                        progressBar.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);

                    }

                    calculateTotalAmount(cartModelList);
                }
            }
        });




        return  root;
    }

    private void calculateTotalAmount(List<MyCartModel> cartModelList) {
        double totalAmount = 0.0;
        for (MyCartModel myCartModel : cartModelList){
            totalAmount += myCartModel.getTotalPrice();
        }

        overTotalAmount.setText("Total Amount: " + totalAmount);
    }
}