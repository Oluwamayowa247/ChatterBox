package com.example.chatterbox;

import android.content.Context;

import  com.example.chatterbox.signupFragment.LoginTabFragment;
import   com.example.chatterbox.signupFragment.SignUpFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.chatterbox.signupFragment.LoginTabFragment;

public class LoginAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs = 2;

    @Override
    public int getCount() {
        return totalTabs;
    }

    public LoginAdapter(FragmentManager fm, Context context, int totalTabs){
        super(fm);
        this.context = context;
        this.totalTabs =  totalTabs;

    }
    public Fragment getItem(int position){
        switch (position){
            case 0:
                LoginTabFragment loginTabFragment =  new LoginTabFragment();
            case 1:
                SignUpFragment signUpFragment = new SignUpFragment();
            default:
                return  null;

        }

    }
}
