package com.example.myapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class List_CustomAdapter extends AppCompatActivity {

    public static final String TAG="ListCustomAdapter";
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_custom_adapter);

        listView=(ListView) findViewById(R.id.custom_list);

        PersonContact person1=new PersonContact("Manikandan","12-20-1998",1234567890);
        PersonContact person2=new PersonContact("Karthi","12-20-1998",1234567890);
        PersonContact person3=new PersonContact("Tamil","12-20-1998",1234567890);
        PersonContact person4=new PersonContact("Zubair","12-20-1998",1234567890);
        PersonContact person5=new PersonContact("Kani","12-20-1998",1234567890);

        ArrayList<PersonContact> personList=new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);

        PersonListAdapter adapter=new PersonListAdapter(this,R.layout.activity_list_custom_adapter,personList);
        listView.setAdapter(adapter);



    }
}