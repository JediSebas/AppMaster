package com.jedisebas.appmaster.ui.systemyliczbowe.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jedisebas.appmaster.ui.podsieci.ui.main.Podsieci1;
import com.jedisebas.appmaster.ui.podsieci.ui.main.Podsieci2;

public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Systemyliczb1();
            case 1:
                return new Systemyliczb2();
            case 2:
                return new Systemyliczb3();
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Opis";
            case 1:
                return "Główne systemy";
            case 2:
                return "Zapisy binarne";
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}