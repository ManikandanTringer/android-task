package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LayoutDemo extends AppCompatActivity {

    private Button linear_layout,relative_layout,frame_layout,contraint_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_demo);
        linear_layout=(Button) findViewById(R.id.linear_layout);
        relative_layout=(Button) findViewById(R.id.relative_layout);
        frame_layout=(Button) findViewById(R.id.frame_layout);
        contraint_layout=(Button) findViewById(R.id.contraint_layout);

        linear_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().add(R.id.fragment_layout_container,
                        new LinearFragment()).addToBackStack(null).commit();
            }
        });
        relative_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_layout_container,
                        new RelaviteFragment()).addToBackStack(null).commit();
            }
        });
        frame_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_layout_container,
                        new FrameFragment()).addToBackStack(null).commit();
            }
        });
        contraint_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().add(R.id.fragment_layout_container,
                        new ConstraintFragment()).addToBackStack(null).commit();
            }
        });
    }
}