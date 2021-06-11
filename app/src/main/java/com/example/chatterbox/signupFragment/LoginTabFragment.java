package com.example.chatterbox.signupFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chatterbox.R;

import org.jetbrains.annotations.NotNull;

public class LoginTabFragment extends Fragment {

    EditText phoneNum, password;
    Button login;
    TextView forgotPass;
    float v = 0;



    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signin_tab_fragment, container, false);

        phoneNum = root.findViewById(R.id.phone_num);
        password = root.findViewById(R.id.password);
        login = root.findViewById(R.id.login);
        forgotPass = root.findViewById(R.id.forgot_password);


        phoneNum.setTranslationX(800);
        password.setTranslationX(800);
        forgotPass.setTranslationX(800);
        login.setTranslationX(800);

        phoneNum.setAlpha(v);
        password.setAlpha(v);
        forgotPass.setAlpha(v);
        login.setAlpha(v);


        phoneNum.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        forgotPass.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(500).start();
        login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(700).start();












        return root;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
