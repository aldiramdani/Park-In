package com.d3ifcool.park_in;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DevActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev);
        ViewPager viewPager = (ViewPager)findViewById(R.id.viewpager_dev);
//        TabLayout tab = findViewById(R.id.tab_dev);
        DevAdapter adapter = new DevAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
//        tab.setupWithViewPager(viewPager);
    }
}
