package com.jedisebas.appmaster.ui.generliczb.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.jedisebas.appmaster.ui.lotto.ui.main.Lotto1;
import com.jedisebas.appmaster.ui.lotto.ui.main.Lotto2;

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
                return new Generliczb();
            case 1:
                return new RandNums();
            case 2:
                return new PrimeNums();
            case 3:
                return new FibbNums();
            case 4:
                return new Factorial();
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
                return "Losowe liczby";
            case 2:
                return "Liczby pierwsze";
            case 3:
                return "Liczby Fibonacciego";
            case 4:
                return "Silnia";
        }
        return null;
    }

    @Override
    public int getCount() {
        // Show 5 total pages.
        return 5;
    }
}