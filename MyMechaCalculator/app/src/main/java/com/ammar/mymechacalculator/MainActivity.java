package com.ammar.mymechacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {
double a= 0,b = 0;
boolean tambah, bagi, kali, kurang, mod, titik;
    TextView text;
    Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,btambah,bkurang,bkali,bbagi,bmod,btitik,bdel,bansw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.txt1);
        b0 = findViewById(R.id.b0);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);
        btambah = findViewById(R.id.tambah);
        bkurang = findViewById(R.id.kurang);
        bbagi = findViewById(R.id.bagi);
        bkali = findViewById(R.id.kali);
        bmod = findViewById(R.id.mod);
        btitik = findViewById(R.id.titik);
        bdel = findViewById(R.id.del);
        bansw = findViewById(R.id.ans);

        b1.setOnClickListener(v -> {
                text.setText(text.getText() + "1");
        });

        b2.setOnClickListener(v -> {
            text.setText(text.getText() + "2");
        });

        b3.setOnClickListener(v -> {
            text.setText(text.getText() + "3");
        });

        b4.setOnClickListener(v -> {
            text.setText(text.getText() + "4");
        });

        b5.setOnClickListener(v -> {
            text.setText(text.getText() + "5");
        });

        b6.setOnClickListener(v -> {
            text.setText(text.getText() + "6");
        });

        b7.setOnClickListener(v -> {
            text.setText(text.getText() + "7");
        });

        b8.setOnClickListener(v -> {
            text.setText(text.getText() + "8");
        });

        b9.setOnClickListener(v -> {
            text.setText(text.getText() + "9");
        });

        b0.setOnClickListener(v -> {
            text.setText(text.getText() + "0");
        });

        btitik.setOnClickListener(v -> {
            if(titik){}
            else {
                text.setText(text.getText() + ".");
                titik = true;
            }
            });

        bdel.setOnClickListener(v -> {
            text.setText(null);
            a = 0;
            b = 0;
        });

        btambah.setOnClickListener(v -> {
            if(text.getText().length() != 0){
            a = parseFloat((String) text.getText());
            tambah = true;
            titik = false;
            text.setText(null);
            }
        });

        bbagi.setOnClickListener(v -> {
            if(text.getText().length() != 0){
                a = parseFloat((String) text.getText());
                bagi = true;
                titik = false;
                text.setText(null);
            }
        });

        bkali.setOnClickListener(v -> {
            if(text.getText().length() != 0){
                a = parseFloat((String) text.getText());
                kali = true;
                titik = false;
                text.setText(null);
            }
        });

        bmod.setOnClickListener(v -> {
            if(text.getText().length() != 0){
                a = parseFloat((String) text.getText());
                mod = true;
                titik = false;
                text.setText(null);
            }
        });

        bkurang.setOnClickListener(v -> {
            if(text.getText().length() != 0){
                a = parseFloat((String) text.getText());
                kurang = true;
                titik = false;
                text.setText(null);
            }
        });

        bansw.setOnClickListener(v -> {
                answer();
        });
    }

    public void answer(){

        if(tambah || bagi || kali || kurang || mod){
            b = parseFloat((String) text.getText());
        }
        if(tambah){
            text.setText(a+b + "");
            tambah = false;
        }
        if(kurang){
            text.setText(a-b + "");
            kurang = false;
        }
        if(bagi){
            text.setText(a/b + "");
            bagi = false;
        }
        if(kali){
            text.setText(a*b + "");
            kali = false;
        }
        if(mod){
            text.setText(a%b + "");
            mod = false;
        }
    }
}