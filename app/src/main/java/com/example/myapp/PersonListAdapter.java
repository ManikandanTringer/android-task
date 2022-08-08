package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PersonListAdapter extends ArrayAdapter<PersonContact> {
    private static final String TAG = "PersonListAdapter";
    private Context context;
    int resource;

    public PersonListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<PersonContact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         String name=getItem(position).getName();
         String birthday=getItem(position).getBirthday();
         int phoneno=getItem(position).getPhoneno();

         PersonContact personContact=new PersonContact(name,birthday,phoneno);

        LayoutInflater inflater=LayoutInflater.from(context);
        convertView=inflater.inflate(resource,parent,false);

        TextView name_txt=(TextView) convertView.findViewById(R.id.name_text);
        TextView phoneno_txt=(TextView) convertView.findViewById(R.id.phoneno);
        TextView bday_txt=(TextView) convertView.findViewById(R.id.bday);
        name_txt.setText(name);
        phoneno_txt.setText(birthday);
        bday_txt.setText(phoneno);

        return convertView;
//        return super.getView(position, convertView, parent);
    }
}
