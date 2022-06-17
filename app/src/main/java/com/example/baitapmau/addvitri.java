package com.example.baitapmau;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addvitri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addvitri);


        Button btnaddViTri = (Button) findViewById(R.id.btnaddViTri);
        btnaddViTri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenVT = ((EditText) findViewById(R.id.textVTTen)).getText().toString();
                String motaVT = ((EditText) findViewById(R.id.textVTMoTa)).getText().toString();
                ViTri vt = new ViTri();
                vt.setTen(tenVT);
                vt.setMoTa(motaVT);
                ViTriDAO dao = new ViTriDAO(addvitri.this);

                if (dao.addViTri(vt)) {
                    Toast.makeText(addvitri.this, "OKE", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(addvitri.this, "NOT OKE", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}