package com.example.myecomerce;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myecomerce.Login1.Login;
import com.example.myecomerce.Login1.Register;
import com.example.myecomerce.activities.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class Sanh extends AppCompatActivity {
    TextView login,register;

    ProgressBar progressBar;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sanh);

        auth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        if(auth.getCurrentUser() != null){
            progressBar.setVisibility(View.VISIBLE);
            startActivity(new Intent(Sanh.this, MainActivity.class));
            Toast.makeText(this,"Vui lòng đợi giây lát, chúng tôi sẽ đưa bạn vô trang chính",Toast.LENGTH_SHORT).show();
            finish();
        }

        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sanh.this, Login.class);
                startActivity(intent);
            }
        });


        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Sanh.this, Register.class);
                startActivity(intent);
            }
        });

    }
}
