package com.example.chatterbox.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.chatterbox.LoginActivity;
import com.example.chatterbox.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OnBoardingFragment3 extends Fragment {

    FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_onboarding3, container,false );

        fab = root.findViewById(R.id.fab_login);

         fab.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

               Intent intent = new Intent(getActivity(), LoginActivity.class);

               startActivity(intent);

             }
         });


        return  root;

//        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
