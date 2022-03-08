package com.example.casestudy02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String hoten = getIntent().getExtras().getString("ht");
        String namsinh = getIntent().getExtras().getString("ns");
        String st="";

        st="Họ và tên: "+ hoten +  "Năm sinh:" + namsinh;

        TextView textView_KetQua = findViewById(R.id.textView_KetQua);
        textView_KetQua.setText(st);
    }
}