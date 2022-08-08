package com.example.myapp;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class List_ArrayAdapter extends AppCompatActivity {

    private ListView array_list;

    String domain[]=new String[]{"Web Developer","Android Developer","IOS developer","Cloud Engineer","Data Scientist"};
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_array_adapter);

        array_list=(ListView) findViewById(R.id.array_list);
        arrayAdapter=new ArrayAdapter<String>(List_ArrayAdapter.this, android.R.layout.simple_list_item_1,domain);
         array_list.setAdapter(arrayAdapter);
    }
}