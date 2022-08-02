package com.example.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.util.Calendar;

public class DialogSnackbar extends AppCompatActivity implements DialogDemo.DialogDemoListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private Button snackbar,dialog;
    private TextView usertxt;
    private ImageView selectedDate,selectedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_snackbar);

        snackbar=(Button) findViewById(R.id.snackbar);
        dialog=(Button)findViewById(R.id.dialog);
        usertxt=(TextView)findViewById(R.id.usertxt);
//        date picker
        selectedDate=(ImageView)findViewById(R.id.date);
//       time picker
        selectedTime=(ImageView)findViewById(R.id.time);

                snackbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar
                        .make(view, "Hi,I'm Snackbar", Snackbar.LENGTH_LONG);
                snackbar.setAction("Undo", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.make(view,"Undo the action",Snackbar.LENGTH_LONG).show();

                    }
                });
                snackbar.show();

            }
        });
                dialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        DialogDemo dialogDemo=new DialogDemo();
                        dialogDemo.show(getSupportFragmentManager(),"simpleDialog");

                    }
                });
//                datepicker dialog
        selectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker=new DatePickerFragment();
                datePicker.show(getSupportFragmentManager(),"date picker");
            }
        });

//              timepicker dialog
        selectedTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment timePicker=new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });



    }

    @Override
    public void setText(String user) {
        usertxt.setText(user);
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        Calendar calendar=Calendar.getInstance();
        calendar.set(Calendar.YEAR,year);
        calendar.set(Calendar.MONTH,month);
        calendar.set(Calendar.DAY_OF_MONTH,day);
        String currentDateValue= DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        TextView textView=(TextView) findViewById(R.id.usertxt);
        textView.setText(currentDateValue);
    }

    @Override
    public void onTimeSet(TimePicker view, int hour, int minute) {

        usertxt.setText("Time: "+hour+":"+minute);

    }
}