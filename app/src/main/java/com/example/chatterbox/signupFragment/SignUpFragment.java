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

public class SignUpFragment extends Fragment {

    EditText phoneNUm, passWord, firstName, lastName;
    Button  signUp;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        phoneNUm = root.findViewById(R.id.phone_num);
        passWord = root.findViewById(R.id.password);
        firstName = root.findViewById(R.id.first_name);
        lastName = root.findViewById(R.id.last_name);





        return  root;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
