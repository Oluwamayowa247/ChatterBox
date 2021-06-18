package com.example.chatterbox;



import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fb,google,twitter;
    float v = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout =  findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager);
        fb = findViewById(R.id.fab_fb);
        twitter = findViewById(R.id.fab_tw);
        google = findViewById(R.id.fab_google);


        tabLayout.setupWithViewPager(viewPager);
//        Objects.requireNonNull(tabLayout.getTabAt(0)).setText("Login");
//        Objects.requireNonNull(tabLayout.getTabAt(1)).setText("Sign Up");

        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("Sign Up"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapter = new  LoginAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

         // viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
          fb.setTranslationY(300);
          google.setTranslationY(300);
          twitter.setTranslationY(300);
          tabLayout.setTranslationY(300);


          fb.setAlpha(v);
          google.setAlpha(v);
          twitter.setAlpha(v);
          tabLayout.setAlpha(v);

          fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
          google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
          twitter.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
         tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(100).start();



    }
}