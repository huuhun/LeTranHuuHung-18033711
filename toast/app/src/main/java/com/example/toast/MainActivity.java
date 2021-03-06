package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AlertDialog.Builder mydialog = new AlertDialog.Builder(this);
        mydialog.setTitle("Thông báo");
        final CharSequence[] items= {"Đỏ","Vàng","Cam"};
        boolean check[]={false, false, false};
        mydialog.setMultiChoiceItems(items, check, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                check[i]= b;

            }
        });
        mydialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String st="";
                for(int j=0;j< items.length;j++)
                    if(check[j])
                    st += items[j].toString() + " ";
                Toast.makeText(MainActivity.this,st,Toast.LENGTH_SHORT).show();
            }
        });
        /*
        mydialog.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,items[i].toString(),Toast.LENGTH_SHORT).show();

            }
        });
       /*
        mydialog.setItems(items, new DialogInterface.OnClickListener() {
         /*
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, items[1].toString(), Toast.LENGTH_SHORT).show();
            }
        });*/
       /* mydialog.setPositiveButton("Yes",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface ,int i) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn yes", Toast.LENGTH_SHORT).show();
            }

        });
        mydialog.setNegativeButton("No",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface ,int i) {
                Toast.makeText(MainActivity.this, "Bạn đã chọn no", Toast.LENGTH_SHORT).show();
            }

        });
        */
        AlertDialog dialog=mydialog.create();
        dialog.show();
    }
}