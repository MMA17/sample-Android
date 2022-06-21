package com.example.baitapmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNhanVien = findViewById(R.id.btnNhanVien);
        btnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, nhanvien_activity.class);
                startActivity(i);
            }
        });

        Button btnVitri = findViewById(R.id.btnViTri);
        btnVitri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, vitri_activity.class);
                startActivity(i);
            }
        });

        Button btnNVVT = findViewById(R.id.btnViTriNhanVien);
        btnNVVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NhanVienViTri.class);
                startActivity(i);
            }
        });

        Button DSNVVT = findViewById(R.id.btnDSVTNV);
        DSNVVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, DSNhanVienViTri.class);
                startActivity(i);
            }
        });

        Button nv95 = (Button) findViewById(R.id.btnNV95);
        nv95.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, NhanVien95.class);
                startActivity(i);
            }
        });
    }
}