package com.example.myecomerce;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myecomerce.models.UserModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {


    TextView textView1;
    Button registerBtn;
    EditText name, email, password;

    FirebaseAuth auth;
    FirebaseDatabase database;


    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        anhxa();

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);


        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this, SignIn.class);
                startActivity(intent);
            }
        });

        registerBtn= findViewById(R.id.registerBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
                progressBar.setVisibility(View.VISIBLE);
            }


        });
    }
    private void createUser() {

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();


        if (TextUtils.isEmpty(userName)){
            Toast.makeText(this,"Name is Empty !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userPassword)){
            Toast.makeText(this,"Password is Empty !", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(userEmail)){
            Toast.makeText(this,"Email is Empty !", Toast.LENGTH_SHORT).show();
            return;
        }
        if(userPassword.length() < 6){
            Toast.makeText(this,"Password Length must be longer than 6", Toast.LENGTH_SHORT).show();
            return;
        }


        //Create User

        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            UserModel userModel = new UserModel(userName,userEmail,userPassword);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(userModel);

                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(SignUp.this,"Registration Successfully",Toast.LENGTH_SHORT).show();

                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(SignUp.this,"Registration Failed" + task.getException(),Toast.LENGTH_SHORT).show();

                        }
                        }
                });

    }


    public void anhxa()
    {
        name = findViewById(R.id.fullName);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.edtPass);
        textView1 = findViewById(R.id.createText);
    }
}