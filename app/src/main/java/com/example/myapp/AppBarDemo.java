package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class AppBarDemo extends AppCompatActivity {

    private Toolbar toolbar;
    FloatingActionButton fabShare;
    CoordinatorLayout coordinate_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_demo);

        coordinate_layout=(CoordinatorLayout)findViewById(R.id.coordinate_layout);
        toolbar = (Toolbar) findViewById(R.id.image_toolbar);
        setSupportActionBar(toolbar);
        fabShare = (FloatingActionButton) findViewById(R.id.fab_share);
        fabShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AppBarDemo.this,ScrollinTask.class);
                startActivity(intent);
                Snackbar.make(coordinate_layout, "Share", Snackbar.LENGTH_LONG).setAction("View", null).show();
//                Toast.makeText(AppBarDemo.this, "Share the content", Toast.LENGTH_SHORT).show();
                    fabShare.setEnabled(false);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        super.onCreateOptionsMenu(menu);

        getMenuInflater().inflate(R.menu.option_menu, menu);

        return true;
    }
}