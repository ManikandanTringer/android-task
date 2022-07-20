package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FragmentTask extends AppCompatActivity {
    Fragment1 fragment=new Fragment1();
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    Button add,pop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_task);
        add=(Button)findViewById(R.id.add);
        fragmentManager=getSupportFragmentManager();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newFragment();
            }
        });
//        pop.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                   int count = getSupportFragmentManager().getBackStackEntryCount();
//                     if(count > 1) {
//                      getSupportFragmentManager().popBackStack("0",
//                      FragmentManager.POP_BACK_STACK_INCLUSIVE);
//    }
//                    getSupportFragmentManager().popBackStack(1,
//                        FragmentManager.POP_BACK_STACK_INCLUSIVE);
//            }
//        });

    }


    private void newFragment() {
        Fragment fragment;
        switch (fragmentManager.getBackStackEntryCount()){
            case 0: fragment = new Fragment1(); break;
            case 1: fragment = new Fragment2();break;
            case 2: fragment = new Fragment3(); break;
            default: fragment = new Fragment1();break;
        }

        fragmentTransaction=fragmentManager.beginTransaction().setReorderingAllowed(true);
        fragmentTransaction.add(R.id.fragment_container,fragment,"demofragment");
        fragmentTransaction.addToBackStack("frag");
        fragmentTransaction.commit();
//        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,fragment).commit();

    }

}
