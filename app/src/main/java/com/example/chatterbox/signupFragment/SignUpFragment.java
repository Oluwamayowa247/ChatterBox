package com.example.chatterbox.signupFragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chatterbox.Dashboard;
import com.example.chatterbox.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SignUpFragment extends Fragment {

    EditText emailAddr, passWord, firstName, lastName;
    Button  signUp;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        emailAddr = root.findViewById(R.id.email_address);
        passWord = root.findViewById(R.id.password);
        firstName = root.findViewById(R.id.first_name);
        lastName = root.findViewById(R.id.last_name);
        signUp = root.findViewById(R.id.sign_up);
        progressBar = root.findViewById(R.id.simpleProgressBar);



            mAuth = FirebaseAuth.getInstance();

            if(mAuth.getCurrentUser() !=null){

                startActivity(new Intent(getActivity(), Dashboard.class));


            }






            signUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = emailAddr.getText().toString().trim();
                    String pass = passWord.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        emailAddr.setError("Enter Valid Address Na");
                    }
                    if (TextUtils.isEmpty(pass)) {
                        passWord.setError("Put Password Joor");
                    }

                    if (pass.length() < 6) {
                        passWord.setError("Make the Password reach six na");
                    }
                    progressBar.setVisibility(View.VISIBLE);


                    //  register user on firebase
                    mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(getActivity(), "User Created", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getActivity(), Dashboard.class));
                            } else {
                                Toast.makeText(getActivity(), "Error While Creating User" +
                                                Objects.requireNonNull(task.getException()).getMessage(),
                                        Toast.LENGTH_SHORT).show();
                            }
                        }

                    });


                    signUp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), Dashboard.class);
                        }
                    });


                }

            });


            return root;
    }
}




