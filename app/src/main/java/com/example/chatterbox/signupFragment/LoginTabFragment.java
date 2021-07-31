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
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chatterbox.Dashboard;
import com.example.chatterbox.LocationActivity;
import com.example.chatterbox.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class LoginTabFragment extends Fragment {

    EditText emailAddr, password;
    Button login;
    TextView forgotPass;
    ProgressBar loginBar;
    FirebaseAuth mAuth;
    float v = 0;



    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signin_tab_fragment, container, false);

        emailAddr = root.findViewById(R.id.email_address);
        password = root.findViewById(R.id.password);
        login = root.findViewById(R.id.login);
        forgotPass = root.findViewById(R.id.forgot_password);
        loginBar = root.findViewById(R.id.login_progress);

        mAuth = FirebaseAuth.getInstance();



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailAddr.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    emailAddr.setError("Enter your email address joor");
                }
                if (TextUtils.isEmpty(pass)) {
                    password.setError("Password nko? Put am Joor");
                }

                if (pass.length() < 6) {
                    password.setError("Oga your password no complete o");
                }
                loginBar.setVisibility(View.VISIBLE);

                //Authenticate User

                mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                       if(task.isSuccessful()){

                           Toast.makeText(getActivity(), "Welcome Back Omo Iya mii", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(getActivity(), LocationActivity.class));
                       } else {
                           Toast.makeText(getActivity(), "Error jare !" +
                                           Objects.requireNonNull(task.getException()).getMessage(),
                                   Toast.LENGTH_SHORT).show();
                           loginBar.setVisibility(View.GONE);
                       }
                    }


                });


                Intent intent = new Intent(getActivity(), LocationActivity.class);

            }
        });



        emailAddr.setTranslationX(800);
        password.setTranslationX(800);
        forgotPass.setTranslationX(800);
        login.setTranslationX(800);

        emailAddr.setAlpha(v);
        password.setAlpha(v);
        forgotPass.setAlpha(v);
        login.setAlpha(v);


        emailAddr.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();


        return root;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
