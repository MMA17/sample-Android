package com.example.baitapmau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class NhanVien95 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien95);

        NhanVienDAO dao = new NhanVienDAO(NhanVien95.this);
        List<NhanVien> listNV = dao.getNV1995();
        NhanVienAdapter adapter = new NhanVienAdapter(listNV, NhanVien95.this);
        ListView lv = findViewById(R.id.listviewNV95);
        lv.setAdapter(adapter);
    }
}