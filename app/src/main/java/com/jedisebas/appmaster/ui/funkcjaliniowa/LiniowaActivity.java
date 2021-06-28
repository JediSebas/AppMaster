package com.jedisebas.appmaster.ui.funkcjaliniowa;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.jedisebas.appmaster.MainActivity;
import com.jedisebas.appmaster.R;
import com.jedisebas.appmaster.ui.funkcjaliniowa.ui.main.SectionsPagerAdapter;

public class LiniowaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String currentmode = MainActivity.choicetheme.getString("mode", "light");

        if (currentmode.equals("dark")) {
            setTheme(R.style.CiemnyZMotywem);
        } else {
            setTheme(R.style.JasnyZMotywem);
        }
        setContentView(R.layout.activity_liniowa);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }
}