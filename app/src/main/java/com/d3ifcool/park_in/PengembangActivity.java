package com.d3ifcool.park_in;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PengembangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengembang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
