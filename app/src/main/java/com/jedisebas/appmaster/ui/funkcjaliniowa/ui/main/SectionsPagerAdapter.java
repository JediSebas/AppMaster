package com.jedisebas.appmaster.ui.funkcjaliniowa.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

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
                return new Liniowa1();
            case 1:
                return new MiejZer();
            case 2:
                return new Wspol();
            case 3:
                return new Prost();
            case 4:
                return new PrzPkt();
            case 5:
                return new Rown();
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
                return "Miejsca zerowe";
            case 2:
                return "Punkty współliniowe";
            case 3:
                return "Prosta prostopadła";
            case 4:
                return "Prosta przez punkty";
            case 5:
                return "Prosta równoległa";
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 6 total pages.
        return 6;
    }
}