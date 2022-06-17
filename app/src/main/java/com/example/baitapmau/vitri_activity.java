package com.example.baitapmau;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class vitri_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vitri);

        Button btnaddVT = findViewById(R.id.btnAddVT);
        btnaddVT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(vitri_activity.this, addvitri.class);
                startActivity(i);
            }
        });

        ViTriDAO dao = new ViTriDAO(vitri_activity.this);
        List<ViTri> listVT = dao.getAllVitri();
        System.out.println(listVT.size());
        ViTriAdapter adapter = new ViTriAdapter(listVT, vitri_activity.this);
        ListView lv = findViewById(R.id.listviewViTri);
        lv.setAdapter(adapter);
    }
}