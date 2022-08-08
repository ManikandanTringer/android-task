package com.example.myapp;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MenusTaskActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener{

    private  TextView textView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus_task);

        Spinner spinner=findViewById(R.id.spinner_state);
        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.state, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

//        Context menu
        textView=(TextView) findViewById(R.id.text_contextmenu);
        registerForContextMenu(textView);

//        Toolbar
        toolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your option");
        getMenuInflater().inflate(R.menu.floating_context_menu,menu);


    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.option1:
                Toast.makeText(this, "Select", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option2:
                Toast.makeText(this, "Select All", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option3:
                Toast.makeText(this, "Copy", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onContextItemSelected(item);


        }
    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.option_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.search:
                Toast.makeText(this,"Search was selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.reply_option:
                Toast.makeText(this,"Reply was selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.setting:
                Toast.makeText(this,"Setting was selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.subItem1:
                Toast.makeText(this,"Account was selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.subItem2:
                Toast.makeText(this,"Privacy was selected",Toast.LENGTH_LONG).show();
                return true;
            case R.id.subItem3:
                Toast.makeText(this,"Logout was selected",Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void showPopMenu(View view) {
        PopupMenu popupMenu=new PopupMenu(this,view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Paytm was choosed",Toast.LENGTH_SHORT).show();
            case R.id.item2:
                Toast.makeText(this,"PhonePe was choosed",Toast.LENGTH_SHORT).show();
            case R.id.item3:
                Toast.makeText(this,"Gpay was choosed",Toast.LENGTH_SHORT).show();
            case R.id.item4:
                Toast.makeText(this,"PayPal was choosed",Toast.LENGTH_SHORT).show();
            default:
                return false;
        }

    }

//    @Override
//    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String text=adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}