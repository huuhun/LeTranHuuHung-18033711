package com.example.nguoivsmay;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int manghinhbai[]={
            R.mipmap.c1,R.mipmap.c2,R.mipmap.c3,R.mipmap.c4,R.mipmap.c5,
            R.mipmap.c6,R.mipmap.c7,R.mipmap.c8,R.mipmap.c9,R.mipmap.c10,
            R.mipmap.cj,R.mipmap.cq,R.mipmap.ck,
            R.mipmap.d1,R.mipmap.d2,R.mipmap.d3,R.mipmap.d4,R.mipmap.d5,
            R.mipmap.d6,R.mipmap.d7,R.mipmap.d8,R.mipmap.d9,R.mipmap.d10,
            R.mipmap.dj,R.mipmap.dq,R.mipmap.dk,
            R.mipmap.h1,R.mipmap.h2,R.mipmap.h3,R.mipmap.h4,R.mipmap.h5,
            R.mipmap.h6,R.mipmap.h7,R.mipmap.h8,R.mipmap.h9,R.mipmap.h10,
            R.mipmap.hj,R.mipmap.hq,R.mipmap.hk,
            R.mipmap.s1,R.mipmap.s2,R.mipmap.s3,R.mipmap.s4,R.mipmap.s5,
            R.mipmap.s6,R.mipmap.s7,R.mipmap.s8,R.mipmap.s9,R.mipmap.s10,
            R.mipmap.sj,R.mipmap.sq,R.mipmap.sk
    };
    int manghinhbaimay[]={
            R.mipmap.c1,R.mipmap.c2,R.mipmap.c3,R.mipmap.c4,R.mipmap.c5,
            R.mipmap.c6,R.mipmap.c7,R.mipmap.c8,R.mipmap.c9,R.mipmap.c10,
            R.mipmap.cj,R.mipmap.cq,R.mipmap.ck,
            R.mipmap.d1,R.mipmap.d2,R.mipmap.d3,R.mipmap.d4,R.mipmap.d5,
            R.mipmap.d6,R.mipmap.d7,R.mipmap.d8,R.mipmap.d9,R.mipmap.d10,
            R.mipmap.dj,R.mipmap.dq,R.mipmap.dk,
            R.mipmap.h1,R.mipmap.h2,R.mipmap.h3,R.mipmap.h4,R.mipmap.h5,
            R.mipmap.h6,R.mipmap.h7,R.mipmap.h8,R.mipmap.h9,R.mipmap.h10,
            R.mipmap.hj,R.mipmap.hq,R.mipmap.hk,
            R.mipmap.s1,R.mipmap.s2,R.mipmap.s3,R.mipmap.s4,R.mipmap.s5,
            R.mipmap.s6,R.mipmap.s7,R.mipmap.s8,R.mipmap.s9,R.mipmap.s10,
            R.mipmap.sj,R.mipmap.sq,R.mipmap.sk
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView imv_random1 = (ImageView) findViewById(R.id.imv_random1);
        final ImageView imv_random2 = (ImageView) findViewById(R.id.imv_random2);
        final ImageView imv_random3 = (ImageView) findViewById(R.id.imv_random3);
        final ImageView imv_random4 = (ImageView) findViewById(R.id.imv_random4);
        final ImageView imv_random5 = (ImageView) findViewById(R.id.imv_random5);
        final ImageView imv_random6 = (ImageView) findViewById(R.id.imv_random6);
        final TextView tv_kq = (TextView) findViewById(R.id.tv_kq);
        final TextView tv_kqmay = (TextView) findViewById(R.id.tv_kqmay);
        Button btn_random = (Button) findViewById(R.id.btn_random);

        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int value[] = new int[3];///copy (nguoi voi may, may voi may)
                value = laybasongaunhien(0, 51);

                imv_random1.setImageResource(manghinhbai[value[0]]);
                imv_random2.setImageResource(manghinhbai[value[1]]);
                imv_random3.setImageResource(manghinhbai[value[2]]);
                tv_kq.setText(tinhketqua(value));////
                //----------------------------
                int valuemay[] = new int[3];
                valuemay = laybasongaunhien(0, 51);
                imv_random4.setImageResource(manghinhbaimay[valuemay[0]]);
                imv_random5.setImageResource(manghinhbaimay[valuemay[1]]);
                imv_random6.setImageResource(manghinhbaimay[valuemay[2]]);

                tv_kqmay.setText(tinhketquamay(valuemay));////
            }
        });
    }
    private String tinhketqua(int[] value){
        String ketqua = "";
        if (tinhsotay(value)==3){
            ketqua = "Kết quả: 3 tây";
        }else {
            int tong = 0;
            for (int i = 0; i<value.length; i++)
                if (value[i] % 13 < 10)
                    tong += value[i] % 13 + 1;
            if (tong % 10 == 0)
                    ketqua = "Kết quả bù, trong đó có " + tinhsotay(value) + " tây";
            else
                ketqua = "Kết quả là " + (tong % 10) + " nút , trong đó có " + tinhsotay(value) + " tây";
        }
        return ketqua;

    };
    private int tinhsotay(int a[]){
        int k = 0;
        for (int i = 0; i<a.length; i++)
            if ((a[i] % 13 >= 10) && (a[i] % 13 < 13))
                k++;
        return k;
    };
    private int[] laybasongaunhien(int min, int max){
        int baso[] = new int[3];
        int i = 0;
        baso[i++] = random(min,max);
        do{
            int k = random(min, max);
            if (!kiemtratrung(k,baso))
                baso[i++] = k;
        }while (i<3);
        return baso;
    };
    private boolean kiemtratrung(int k, int a[]){
        for (int i = 0; i<a.length; i++)
            if (a[i] == k)
                return true;
        return false;
    };
    private int random(int min, int max){
        return min + (int)(Math.random()*((max - min) + 1));
    }
    /////////////////////////////////////////////////////
    private String tinhketquamay(int[] valuemay){
        String ketqua = "";
        if (tinhsotaymay(valuemay)==3){
            ketqua = "Kết quả: 3 tây";
        }else {
            int tong = 0;
            for (int i = 0; i<valuemay.length; i++)
                if (valuemay[i] % 13 < 10)
                    tong += valuemay[i] % 13 + 1;
            if (tong % 10 == 0)
                ketqua = "Kết quả bù, trong đó có " + tinhsotay(valuemay) + " tây";
            else
                ketqua = "Kết quả là " + (tong % 10) + " nút , trong đó có " + tinhsotay(valuemay) + " tây";
        }
        return ketqua;

    };
    private int tinhsotaymay(int b[]){
        int k = 0;
        for (int i = 0; i<b.length; i++)
            if ((b[i] % 13 >= 10) && (b[i] % 13 < 13))
                k++;
        return k;
    };
    private int[] laybasongaunhienmay(int min, int max){
        int baso[] = new int[3];
        int i = 0;
        baso[i++] = random(min,max);
        do{
            int k = random(min, max);
            if (!kiemtratrung(k,baso))
                baso[i++] = k;
        }while (i<3);
        return baso;
    };
    private boolean kiemtratrungmay(int k, int b[]){
        for (int i = 0; i<b.length; i++)
            if (b[i] == k)
                return true;
        return false;
    };
    private int randommay(int min, int max){
        return min + (int)(Math.random()*((max - min) + 1));
    }
}
