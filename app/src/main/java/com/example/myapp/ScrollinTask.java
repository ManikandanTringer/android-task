package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import com.google.android.material.snackbar.Snackbar;

public class ScrollinTask extends AppCompatActivity {

    ScrollView vertical_scroll;
    NestedScrollView a;
    Button demobtn;
    CoordinatorLayout coordinate_layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollin_task);
        vertical_scroll = (ScrollView) findViewById(R.id.vertical_scroll);
        demobtn = (Button) findViewById(R.id.demobtn);
        coordinate_layout1=(CoordinatorLayout) findViewById(R.id.coordinate_layout1);
        demobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a snackbar
                Snackbar snackbar
                        = Snackbar
                        .make(
                                coordinate_layout1,
                                "Message is deleted",
                                Snackbar.LENGTH_LONG)
                        .setAction(
                                "UNDO",

                                // If the Undo button
                                // is pressed, show
                                // the message using Toast
                                new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Toast.makeText(
                                                        ScrollinTask.this,
                                                        "Undo Clicked",
                                                        Toast.LENGTH_SHORT)
                                                .show();
                                    }
                                });

                snackbar.show();
            }
        });
    }

        }


//    vertical_scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
//        @Override
//        public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//            Log.d("ScrollView","scrollX_"+scrollX+"_scrollY_"+scrollY+"_oldScrollX_"+oldScrollX+"_oldScrollY_"+oldScrollY);
//        }
//    });

