package com.example.ui_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NhanVien> nv_list = new ArrayList<>();
    String[] dv_List;
    ArrayList<NhanVien> nv_List= new ArrayList<>();
    String donvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText et_MaSo = (EditText) findViewById(R.id.editText_MaSo);
        EditText et_HoTen = (EditText) findViewById(R.id.editText_HoTen);
        ListView lv_NhanVien = (ListView) findViewById(R.id.listView_NhanVien);
        RadioGroup rg_GioiTinh = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton rb_Nam = (RadioButton) findViewById(R.id.radioButton_Nam);
        RadioButton rb_Nu = (RadioButton) findViewById(R.id.radioButton_Nu);
        TextView tv = (TextView) findViewById(R.id.textView_DonVi);

        Spinner sp_DonVi = (Spinner) findViewById(R.id.spinner_DonVi);
        dv_List = getResources().getStringArray(R.array.donvi_list);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, dv_List);
        sp_DonVi.setAdapter(adapter);
        sp_DonVi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                donvi = dv_List[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        Button bt_them = findViewById(R.id.button_Them);
        bt_them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int maso = Integer.parseInt(et_MaSo.getText().toString());
                String hoten = et_HoTen.getText().toString();
                String gioitinh = ((RadioButton) findViewById(rg_GioiTinh.getCheckedRadioButtonId())).getText().toString();
                NhanVien nv = new NhanVien(maso, hoten, gioitinh, donvi);
                //Thêm nhân viên vào danh sách
                nv_List.add(nv);

                //Đưa danh sách nhân viên vào ListView
                ArrayList<String> listItems = new ArrayList<>();
                for (NhanVien nv1:nv_List)
                    listItems.add(nv1.toString());
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
                lv_NhanVien.setAdapter(adapter);
            }

        });

        lv_NhanVien.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NhanVien nv = nv_List.get(i);
                et_MaSo.setText(nv.getMaso());
                et_HoTen.setText(nv.getHoten());
                //Xử lý Gioi tính
                if(nv.getGioitinh().equals("Nam"))
                    rb_Nam.setChecked(true);
                else
                    rb_Nu.setChecked(true);
                // XỬ LÝ ĐƠN VỊ
                for(int j=0; j < dv_List.length; j++)
                    if(dv_List[j].equals(nv.getDonvi()))
                        sp_DonVi.setSelection(j);
            }
        });
    }

}