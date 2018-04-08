package com.d3ifcool.park_in;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PengembangActivity extends AppCompatActivity {
    TextView pengembang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengembang);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
