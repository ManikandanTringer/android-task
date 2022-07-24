package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class FrontPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_nav,
                new HomeFragment()).commit();
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment=null;
            switch (item.getItemId()){

                case R.id.nav_home:
                    selectedFragment=new HomeFragment();
                    break;
                case R.id.nav_cart:
                    selectedFragment=new CartFragment();
                    break;
                case R.id.nav_search:
                    selectedFragment=new SearchFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_nav,
                    selectedFragment).commit();
            return true;
        });
    }
}