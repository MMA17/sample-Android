package com.example.baitapmau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DSNhanVienViTri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsnhan_vien_vi_tri);

        NhanVienViTriDAO dao = new NhanVienViTriDAO(DSNhanVienViTri.this);
        List<NVVTClass> listNVVT = new ArrayList<>();
        listNVVT = dao.getallNVVT();
        System.out.println(listNVVT.size());
        NVVTAdapter adapter = new NVVTAdapter(DSNhanVienViTri.this, listNVVT);
        ListView lv = findViewById(R.id.listviewNVVT);
        lv.setAdapter(adapter);

    }
}