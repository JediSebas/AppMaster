package com.jedisebas.appmaster.ui.crypto.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jedisebas.appmaster.ui.aurebesh.ui.main.Aurebesh1;
import com.jedisebas.appmaster.ui.aurebesh.ui.main.Aurebesh2;

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
                return new Crypto1();
            case 1:
                return new Crypto2();
            case 2:
                return new Crypto3();
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
                return "ROT-13";
            case 2:
                return "Vigenère";
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }
}