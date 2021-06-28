package com.jedisebas.appmaster.ui.calendar;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.jedisebas.appmaster.MainActivity;
import com.jedisebas.appmaster.R;
import com.jedisebas.appmaster.ui.calendar.ui.main.Calendar2;
import com.jedisebas.appmaster.ui.calendar.ui.main.SectionsPagerAdapter;

public class CalendarActivity extends AppCompatActivity {

    public static SharedPreferences saveTitle, saveSubtitle;

    public static void changeTitleANDSubtitle(String t, String st) {
        SharedPreferences.Editor ch = saveTitle.edit();
        ch.putString("keytitle", t).commit();
        SharedPreferences.Editor ch2 = saveSubtitle.edit();
        ch2.putString("keysubtitle", st).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String currentmode = MainActivity.choicetheme.getString("mode", "light");

        if (currentmode.equals("dark")) {
            setTheme(R.style.CiemnyZMotywem);
        } else {
            setTheme(R.style.JasnyZMotywem);
        }
        setContentView(R.layout.activity_calendar);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        saveTitle = getSharedPreferences("titleinfo", 0);
        saveSubtitle = getSharedPreferences("subtitleinfo", 0);
        String storedTitle = saveTitle.getString("keytitle", "");
        String storedSubtitle = saveSubtitle.getString("keysubtitle", "");
        Calendar2.setTitleANDSubtitle(storedTitle, storedSubtitle);
    }
}