package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class List_SimpleAdapter extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView simpleAdapterList;
    private ArrayList<HashMap<String, Object>> arrayList;
    private static final String NAME = "_name";
    private static final String IMAGE = "_image";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_simple_adapter);
        simpleAdapterList = (ListView) findViewById(R.id.simple_list);
        loadData();
        SimpleAdapter adapter = new SimpleAdapter(this, arrayList, R.layout.list_view_holder, new String[]{NAME, IMAGE}, new int[]{R.id.name_holder, R.id.image_holder});
        simpleAdapterList.setAdapter(adapter);
        simpleAdapterList.setOnItemClickListener(this);

    }

    private void loadData() {
        arrayList = new ArrayList<>();
        HashMap<String, Object> data1 = new HashMap<>();
        data1.put(NAME, List_SimpleAdapter.this.getResources().getString(R.string.add));
        data1.put(IMAGE, R.drawable.ic_person);
        arrayList.add(data1);
        HashMap<String, Object> data2 = new HashMap<>();
        data2.put(NAME, List_SimpleAdapter.this.getResources().getString(R.string.add));
        data2.put(IMAGE, R.drawable.ic_person);
        arrayList.add(data2);
        HashMap<String, Object> data3 = new HashMap<>();
        data3.put(NAME, List_SimpleAdapter.this.getResources().getString(R.string.add));
        data3.put(IMAGE, R.drawable.ic_person);
        arrayList.add(data3);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(this, "Item :"+i, Toast.LENGTH_SHORT).show();
    }
}