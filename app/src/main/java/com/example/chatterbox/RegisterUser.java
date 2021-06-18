package com.example.chatterbox;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.chatterbox.signupFragment.SignUpFragment;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class RegisterUser extends AppCompatActivity {

    EditText emailAddr, passWord, firstName, lastName;
    Button signUp;
    ProgressBar progressBar;
////    private FirebaseAuth mAuth;
//
//    @Override
//    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.signup_tab_fragment);
//
//        emailAddr = findViewById(R.id.email_address);
//        passWord = findViewById(R.id.password);
//        firstName = findViewById(R.id.first_name);
//        lastName = findViewById(R.id.last_name);
//        signUp = findViewById(R.id.sign_up);
//
//
//        mAuth = FirebaseAuth.getInstance();
//        progressBar = findViewById(R.id.simpleProgressBar);
//
//        if(mAuth.getCurrentUser() !=null){
//            startActivity(new Intent(getApplicationContext(), Dashboard.class));
//            finish();
//
//        }
//
//        signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = emailAddr.getText().toString().trim();
//                String pass = passWord.getText().toString().trim();
//
//                if (TextUtils.isEmpty(email)) {
//                    emailAddr.setError("Email is Required !!!");
//                }
//                if (TextUtils.isEmpty(pass)) {
//                    passWord.setError("Password is Required !!!");
//                }
//
//                if (pass.length() < 6) {
//                    passWord.setError("Password Must be greater or equal to six Characters");
//                }
//                progressBar.setVisibility(View.VISIBLE);
//
//
//                //register user on firebase
//                mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            Toast.makeText(RegisterUser.this, "User Created", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(getApplicationContext(), Dashboard.class));
//                        } else {
//                            Toast.makeText(RegisterUser.this, "Error While Creating User" +
//                                            Objects.requireNonNull(task.getException()).getMessage(),
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                });
//            }
//        });
//    }
//}
//
//
//
//
//
//
//
//
//
//
}



