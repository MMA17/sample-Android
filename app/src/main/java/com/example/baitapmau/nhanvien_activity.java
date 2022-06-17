package com.example.baitapmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class nhanvien_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhanvien);

        Button btnaddNV = (Button) findViewById(R.id.btnAddNV);
        btnaddNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(nhanvien_activity.this, activity_addNhanVien.class);
                startActivity(i);
            }
        });

        NhanVienDAO dao = new NhanVienDAO(nhanvien_activity.this);
        List<NhanVien> listNV = dao.getAllNhanVien();
        System.out.println(listNV.size());
        NhanVienAdapter adapter = new NhanVienAdapter(listNV, nhanvien_activity.this);
        ListView lv = findViewById(R.id.listviewNhanVien);
        lv.setAdapter(adapter);
    }
}