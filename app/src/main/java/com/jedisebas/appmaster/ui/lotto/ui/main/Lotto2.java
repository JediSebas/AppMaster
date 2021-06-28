package com.jedisebas.appmaster.ui.lotto.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jedisebas.appmaster.R;
import java.util.Random;

public class Lotto2 extends Fragment {


    Random generator = new Random();
    TextView nr1tv, nr2tv, nr3tv, nr4tv, nr5tv, nr6tv;
    EditText nr1et, nr2et, nr3et, nr4et, nr5et, nr6et;
    TextView[] tv = new TextView[6];
    EditText[] et = new EditText[6];
    int[] random = new int[6];
    int[] number = new int[6];

    TextView traftV;
    Button los, sprawdz, czysc;

    void losuj() {
        for (int i=0; i < 6; i++) {
            random[i] = generator.nextInt(48)+1;
        }
    }

    void rantotv(){
        for (int i=0; i < 6; i++ ){
            String str = String.valueOf(random[i]);
            tv[i].setText(str);
        }
    }

    void ettonum(){
        for (int i=0; i < 6; i++) {
            try {
                String str = et[i].getText().toString().trim();
                number[i] = Integer.parseInt(str);
            }catch (NumberFormatException e){
                et[i].setText("0");
            }
            finally {
                String str = et[i].getText().toString().trim();
                number[i] = Integer.parseInt(str);
            }
        }
    }

    int check(int[] a, int[] b){
        int i=0, j, x=0;
        for (; i < 6; i++){
            for (j=0; j<6; j++){
                if (a[i] == b[j]){
                    x++;
                }
            }
        }
        return x;
    }

    void czysc() {
        for (int i=0; i<6; i++){
            et[i].setText("");
        }
    }

    void sprawdz() {
        try {
            rantotv();
            ettonum();
            int wyn = check(number, random);
            traftV.setText("trafienia: " + wyn);
        } catch (Exception e) {
            for (int i = 0; i < 6; i++) {
                et[i].setText("0");
            }
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_lotto2, container, false);
        traftV = root.findViewById(R.id.traftV);
        los = root.findViewById(R.id.losujBtn);
        sprawdz = root.findViewById(R.id.sprawdzBtn);
        czysc = root.findViewById(R.id.czyscBtn);
        tv[0] = nr1tv = (TextView) root.findViewById(R.id.nr1tV);
        tv[1] = nr2tv = (TextView) root.findViewById(R.id.nr2tV);
        tv[2] = nr3tv = (TextView) root.findViewById(R.id.nr3tV);
        tv[3] = nr4tv = (TextView) root.findViewById(R.id.nr4tV);
        tv[4] = nr5tv = (TextView) root.findViewById(R.id.nr5tV);
        tv[5] = nr6tv = (TextView) root.findViewById(R.id.nr6tV);
        et[0] = nr1et = (EditText) root.findViewById(R.id.nr1eT);
        et[1] = nr2et = (EditText) root.findViewById(R.id.nr2eT);
        et[2] = nr3et = (EditText) root.findViewById(R.id.nr3eT);
        et[3] = nr4et = (EditText) root.findViewById(R.id.nr4eT);
        et[4] = nr5et = (EditText) root.findViewById(R.id.nr5eT);
        et[5] = nr6et = (EditText) root.findViewById(R.id.nr6eT);

        los.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                losuj();
            }
        });

        czysc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                czysc();
            }
        });

        sprawdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sprawdz();
            }
        });
        return root;
    }
}
