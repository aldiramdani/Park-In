package com.d3ifcool.park_in;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class PengembangActivity extends AppCompatActivity {
    TextView pengembang;
    public static TextView txt_ver_baru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengembang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txt_ver_baru = (TextView)findViewById(R.id.txt_ver_baru);
        fetchData proses = new fetchData();
        proses.execute();
        pengembang = (TextView)findViewById(R.id.pengembang);
        pengembang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),DevActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

}
