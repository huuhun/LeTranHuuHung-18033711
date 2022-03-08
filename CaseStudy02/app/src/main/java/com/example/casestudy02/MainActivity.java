package com.example.casestudy02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText_HoTen = findViewById(R.id.et_HoTen);
        EditText editText_NamSinh = findViewById(R.id.et_NamSinh);
        Button button_Submit= findViewById(R.id.bt_Submit);


        button_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("ht",editText_HoTen.getText().toString());
                intent.putExtra("ns",editText_NamSinh.getText().toString());
                startActivity(intent);
            }

        });


    }
}