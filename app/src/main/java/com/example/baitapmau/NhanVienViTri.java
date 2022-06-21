package com.example.baitapmau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NhanVienViTri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nhan_vien_vi_tri);

        Button addNVVT = (Button) findViewById(R.id.btnAddNVVT);
        addNVVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idNV = ((EditText) findViewById(R.id.textIDNhanVien)).getText().toString();
                String idVT = ((EditText) findViewById(R.id.textIDViTri)).getText().toString();

                NhanVienViTriDAO dao = new NhanVienViTriDAO(NhanVienViTri.this);
                dao.create();
                if (dao.addNhanVienViTri(Integer.parseInt(idNV), Integer.parseInt(idVT))) {
                    Toast.makeText(NhanVienViTri.this, "OKE", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(NhanVienViTri.this, "NOT OKE", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}