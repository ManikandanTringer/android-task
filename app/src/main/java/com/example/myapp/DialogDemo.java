package com.example.myapp;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogDemo extends DialogFragment {

    String dialogValue;
    EditText username;
    private DialogDemoListener listener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        String[] stateArray=getResources().getStringArray(R.array.state);
        LayoutInflater inflater=requireActivity().getLayoutInflater();
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        View view=inflater.inflate(R.layout.custom_dialog,null);
        username=view.findViewById(R.id.username);
//        custom dialog box
        builder.setView(view)
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        String user=username.getText().toString();
                        listener.setText(user);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });




        //        Single choice items in dialog
//        builder.setSingleChoiceItems(R.array.state, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogValue=stateArray[i];
//            }
//        });

//        builder.setPositiveButton("Show", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                Toast.makeText(getContext(), dialogValue, Toast.LENGTH_SHORT).show();
//            }
//        });

        ////         Simple Alert
//        builder.setTitle("Warning")
//                .setMessage("Error")
//                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                })
//                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//
//                    }
//                });

        return builder.create();
    }
    public interface DialogDemoListener{
        void setText(String user);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener=(DialogDemoListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implement the DialogDemoListener");
        }
    }
}
