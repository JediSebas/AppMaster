package com.jedisebas.appmaster.ui.podsieci.ui.main;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;
import com.jedisebas.appmaster.R;

public class Podsieci2 extends Fragment {

    EditText adres, masc, divi;
    TextView adbin, mcbin;
    TextView as1, as2, as3, as4, as5, as6, as7, as8, as9, as10, as11, as12, as13, as14, as15, as16;
    TextView ar1, ar2, ar3, ar4, ar5, ar6, ar7, ar8, ar9, ar10, ar11, ar12, ar13, ar14, ar15, ar16;
    TextView pz1, pz2, pz3, pz4, pz5, pz6, pz7, pz8, pz9, pz10, pz11, pz12, pz13, pz14, pz15, pz16;
    TextView kz1, kz2, kz3, kz4, kz5, kz6, kz7, kz8, kz9, kz10, kz11, kz12, kz13, kz14, kz15, kz16;
    TextView lhtv;
    TextView[] as = new TextView[16];
    TextView[] ar = new TextView[16];
    TextView[] pz = new TextView[16];
    TextView[] kz = new TextView[16];
    Button divBtn, clearBtn;

    void invis() {
        for (int i = 0; i < as.length; i++) {
            as[i].setVisibility(View.GONE);
            ar[i].setVisibility(View.GONE);
            pz[i].setVisibility(View.GONE);
            kz[i].setVisibility(View.GONE);
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_podsieci2, container, false);

        adres = root.findViewById(R.id.adresipEt);
        masc = root.findViewById(R.id.mascEt);
        divi = root.findViewById(R.id.divideEt);

        adbin = root.findViewById(R.id.adbinTv);
        mcbin = root.findViewById(R.id.mcbinTv);

        divBtn = root.findViewById(R.id.podsieciBtn);
        clearBtn = root.findViewById(R.id.podsieciclearBtn);

        lhtv = root.findViewById(R.id.lhtv);

        as[0] = as1 = root.findViewById(R.id.as1);
        as[1] = as2 = root.findViewById(R.id.as2);
        as[2] = as3 = root.findViewById(R.id.as3);
        as[3] = as4 = root.findViewById(R.id.as4);
        as[4] = as5 = root.findViewById(R.id.as5);
        as[5] = as6 = root.findViewById(R.id.as6);
        as[6] = as7 = root.findViewById(R.id.as7);
        as[7] = as8 = root.findViewById(R.id.as8);
        as[8] = as9 = root.findViewById(R.id.as9);
        as[9] = as10 = root.findViewById(R.id.as10);
        as[10] = as11 = root.findViewById(R.id.as11);
        as[11] = as12 = root.findViewById(R.id.as12);
        as[12] = as13 = root.findViewById(R.id.as13);
        as[13] = as14 = root.findViewById(R.id.as14);
        as[14] = as15 = root.findViewById(R.id.as15);
        as[15] = as16 = root.findViewById(R.id.as16);

        ar[0] = ar1 = root.findViewById(R.id.ar1);
        ar[1] = ar2 = root.findViewById(R.id.ar2);
        ar[2] = ar3 = root.findViewById(R.id.ar3);
        ar[3] = ar4 = root.findViewById(R.id.ar4);
        ar[4] = ar5 = root.findViewById(R.id.ar5);
        ar[5] = ar6 = root.findViewById(R.id.ar6);
        ar[6] = ar7 = root.findViewById(R.id.ar7);
        ar[7] = ar8 = root.findViewById(R.id.ar8);
        ar[8] = ar9 = root.findViewById(R.id.ar9);
        ar[9] = ar10 = root.findViewById(R.id.ar10);
        ar[10] = ar11 = root.findViewById(R.id.ar11);
        ar[11] = ar12 = root.findViewById(R.id.ar12);
        ar[12] = ar13 = root.findViewById(R.id.ar13);
        ar[13] = ar14 = root.findViewById(R.id.ar14);
        ar[14] = ar15 = root.findViewById(R.id.ar15);
        ar[15] = ar16 = root.findViewById(R.id.ar16);

        pz[0] = pz1 = root.findViewById(R.id.pz1);
        pz[1] = pz2 = root.findViewById(R.id.pz2);
        pz[2] = pz3 = root.findViewById(R.id.pz3);
        pz[3] = pz4 = root.findViewById(R.id.pz4);
        pz[4] = pz5 = root.findViewById(R.id.pz5);
        pz[5] = pz6 = root.findViewById(R.id.pz6);
        pz[6] = pz7 = root.findViewById(R.id.pz7);
        pz[7] = pz8 = root.findViewById(R.id.pz8);
        pz[8] = pz9 = root.findViewById(R.id.pz9);
        pz[9] = pz10 = root.findViewById(R.id.pz10);
        pz[10] = pz11 = root.findViewById(R.id.pz11);
        pz[11] = pz12 = root.findViewById(R.id.pz12);
        pz[12] = pz13 = root.findViewById(R.id.pz13);
        pz[13] = pz14 = root.findViewById(R.id.pz14);
        pz[14] = pz15 = root.findViewById(R.id.pz15);
        pz[15] = pz16 = root.findViewById(R.id.pz16);

        kz[0] = kz1 = root.findViewById(R.id.kz1);
        kz[1] = kz2 = root.findViewById(R.id.kz2);
        kz[2] = kz3 = root.findViewById(R.id.kz3);
        kz[3] = kz4 = root.findViewById(R.id.kz4);
        kz[4] = kz5 = root.findViewById(R.id.kz5);
        kz[5] = kz6 = root.findViewById(R.id.kz6);
        kz[6] = kz7 = root.findViewById(R.id.kz7);
        kz[7] = kz8 = root.findViewById(R.id.kz8);
        kz[8] = kz9 = root.findViewById(R.id.kz9);
        kz[9] = kz10 = root.findViewById(R.id.kz10);
        kz[10] = kz11 = root.findViewById(R.id.kz11);
        kz[11] = kz12 = root.findViewById(R.id.kz12);
        kz[12] = kz13 = root.findViewById(R.id.kz13);
        kz[13] = kz14 = root.findViewById(R.id.kz14);
        kz[14] = kz15 = root.findViewById(R.id.kz15);
        kz[15] = kz16 = root.findViewById(R.id.kz16);

        invis();

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adres.setText("");
                masc.setText("");
                divi.setText("");
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                invis();
                AdresIP ip;
                Maska mc;
                int amm;
                try {
                    ip = new AdresIP(adres.getText().toString().trim());
                } catch (Exception e) { ip = new AdresIP("192.168.1.10"); adres.setText("192.168.1.10");
                    Snackbar snackbar = Snackbar.make(v, "Błędny adres IP", Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    TextView textView = (TextView) snackbarView.findViewById(R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);
                    snackbar.show();
                }
                try {
                    mc = new Maska(masc.getText().toString().trim());
                } catch (Exception e) { mc = new Maska("/25"); masc.setText("/25");
                    Snackbar snackbar = Snackbar.make(v, "Błędna maska", Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    TextView textView = (TextView) snackbarView.findViewById(R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);
                    snackbar.show();
                }
                try {
                    amm = Integer.parseInt(divi.getText().toString().trim());
                } catch (NumberFormatException e) { divi.setText("1"); amm = 1;
                    Snackbar snackbar = Snackbar.make(v, "Nie podano ilości podsieci lub nic nie podano", Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    TextView textView = (TextView) snackbarView.findViewById(R.id.snackbar_text);
                    textView.setTextColor(Color.WHITE);
                    snackbar.show();
                }

                if (mc.ones_amount + amm > 32) {
                    mc = new Maska("/25");
                    masc.setText("/25");
                    divi.setText("1");
                    amm = 1;
                    Snackbar.make(v, "Zbyt duża maska lub ilość sieci do podzielenia", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

                division(amm, ip, mc);

                adbin.setText(ip.binary[0]+"."+ip.binary[1] +"."+ip.binary[2]+"."+ip.binary[3]);
                mcbin.setText(mc.binary[0]+"."+mc.binary[1] +"."+mc.binary[2]+"."+mc.binary[3]);
            }
        });

        return root;
    }


    void division(int d, AdresIP ad, Maska mc) {
        int am = d;
        if (am > 64) {
            mc.ones_amount += 7;
        } else if (am > 32) {
            mc.ones_amount += 6;
        } else if (am > 16) {
            mc.ones_amount += 5;
        } else if (am > 8) {
            mc.ones_amount += 4;
        } else if (am > 4) {
            mc.ones_amount += 3;
        } else if (am > 2) {
            mc.ones_amount += 2;
        } else if (am > 1) {
            mc.ones_amount++;
        }

        AdresIP[] adresy = new AdresIP[4 * am];
        for (int i = 0; i < (4*am); i++) { //przypisanie wszystkim adresom tej samej wartości
            adresy[i] = new AdresIP(ad.adres);
        }

        int num = mc.ones_amount % 8;

        for (int i = 1; i < am; i++) { //przypisanie wartości adresom sieciowym oprocz pierwszego
            for (int j = 0; j < i; j++) {
                adresy[i].decAdres[mc.ones_amount/8] += (int) Math.pow(2, (8-num));
            }
        }

        for (int i = am; i <= ((2*am)-1); i++) { //przypisanie wartości adresom broadcast
            adresy[i].decAdres[mc.ones_amount/8] = (int) (adresy[i-am].decAdres[mc.ones_amount/8] + (Math.pow(2, (8-num))-1));
        }

        if (mc.ones_amount < 8) {
            for (int i = (2*am); i < ((2*am)+am); i++) { //przypisanie wartości początkom zakresu
                adresy[i].decAdres[0] = adresy[i-(2*am)].decAdres[0];
            }

            for (int i = ((2*am)+am); i < (4*am); i++) { //przypisanie wartości końcom zakresu
                adresy[i].decAdres[1] = 255;
                adresy[i].decAdres[2] = 255;
                adresy[i].decAdres[0] = adresy[i-(2*am)].decAdres[0];
            }

            for (int i = am; i <= ((2 * am) - 1); i++) { //przypisanie wartości adresom broadcast
                adresy[i].decAdres[1] = 255;
                adresy[i].decAdres[2] = 255;
                adresy[i].decAdres[3] = 255;
            }
        }

        if (mc.ones_amount < 16) {
            for (int i = (2*am); i < ((2*am)+am); i++) { //przypisanie wartości początkom zakresu
                adresy[i].decAdres[1] = adresy[i-(2*am)].decAdres[1];
            }

            for (int i = ((2*am)+am); i < (4*am); i++) { //przypisanie wartości końcom zakresu
                adresy[i].decAdres[2] = 255;
                adresy[i].decAdres[1] = adresy[i-(2*am)].decAdres[1];
            }

            for (int i = am; i <= ((2 * am) - 1); i++) { //przypisanie wartości adresom broadcast
                adresy[i].decAdres[2] = 255;
                adresy[i].decAdres[3] = 255;
            }
        }

        if (mc.ones_amount < 24) {
            for (int i = (2*am); i < ((2*am)+am); i++) { //przypisanie wartości początkom zakresu
                adresy[i].decAdres[2] = adresy[i-(2*am)].decAdres[2];
            }

            for (int i = ((2*am)+am); i < (4*am); i++) { //przypisanie wartości końcom zakresu
                adresy[i].decAdres[2] = adresy[i-(2*am)].decAdres[2];
            }

            for (int i = am; i <= ((2 * am) - 1); i++) { //przypisanie wartości adresom broadcast
                adresy[i].decAdres[3] = 255;
            }
        }


        for (int i = (2*am); i < ((2*am)+am); i++) { //przypisanie wartości początkom zakresu
            adresy[i].decAdres[3] = adresy[i-(2*am)].decAdres[3] + 1;
        }

        for (int i = ((2*am)+am); i < (4*am); i++) { //przypisanie wartości końcom zakresu
            adresy[i].decAdres[3] = adresy[i-(2*am)].decAdres[3] - 1;
        }

        for (int i = 0; i < (4*am); i++) {
            System.out.println("[" + i + "] " + adresy[i].decAdres[mc.ones_amount/8]);
        }

        for (int i = 0; i < am; i++) {
            as[i].setVisibility(View.VISIBLE);
            as[i].setText(adresy[i].decAdres[0]+"."+adresy[i].decAdres[1]+"."+
                    adresy[i].decAdres[2]+"."+adresy[i].decAdres[3]);
        }

        int iiii = am;
        for (int j = 0; j < am; j++) {
            ar[j].setVisibility(View.VISIBLE);
            ar[j].setText(adresy[iiii].decAdres[0]+"."+adresy[iiii].decAdres[1]+"."+
                    adresy[iiii].decAdres[2]+"."+adresy[iiii].decAdres[3]);
            iiii++;
        }

        int pppp = 2*am;
        for (int j = 0; j < am; j++) {
            pz[j].setVisibility(View.VISIBLE);
            pz[j].setText(adresy[pppp].decAdres[0]+"."+adresy[pppp].decAdres[1]+"."+
                    adresy[pppp].decAdres[2]+"."+adresy[pppp].decAdres[3]);
            pppp++;
        }

        int kkkk = ((2*am)+am);
        for (int j = 0; j < am; j++) {
            kz[j].setVisibility(View.VISIBLE);
            kz[j].setText(adresy[kkkk].decAdres[0]+"."+adresy[kkkk].decAdres[1]+"."+
                    adresy[kkkk].decAdres[2]+"."+adresy[kkkk].decAdres[3]);
            kkkk++;
        }

        int lhi = (int) Math.pow(2, 32 - mc.ones_amount);
        String lh = Integer.toString(lhi-2);
        lhtv.setText(lh);
    }
}
