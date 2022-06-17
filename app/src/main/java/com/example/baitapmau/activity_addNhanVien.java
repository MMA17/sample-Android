package com.example.baitapmau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class activity_addNhanVien extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nhan_vien);
        Button addNV = (Button) findViewById(R.id.btnaddNhanVien);
        addNV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = new NhanVien();
                String ten = ((EditText) findViewById(R.id.textNVTen)).getText().toString();
                String dob = ((EditText) findViewById(R.id.textNVDOB)).getText().toString();
                String quequan = ((EditText) findViewById(R.id.textNVQueQuan)).getText().toString();
                String trinhdo = ((EditText) findViewById(R.id.textNVTrinhDo)).getText().toString();
                nv.setTen(ten);
                nv.setDob(dob);
                nv.setQueQuan(quequan);
                nv.setTrinhdo(trinhdo);
                NhanVienDAO dao = new NhanVienDAO(activity_addNhanVien.this);
                if (dao.addNhanVien(nv)) {
                    Toast.makeText(activity_addNhanVien.this,"OK", Toast.LENGTH_LONG).show();
                    finish();
                }
                else {
                    Toast.makeText(activity_addNhanVien.this, "NOT OKE", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}