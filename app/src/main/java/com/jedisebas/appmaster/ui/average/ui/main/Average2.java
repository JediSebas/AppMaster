package com.jedisebas.appmaster.ui.average.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jedisebas.appmaster.R;

public class Average2 extends Fragment {

    EditText digits;
    TextView result;
    Button obl;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_average2, container, false);
        digits = root.findViewById(R.id.averdigitEt);
        result = root.findViewById(R.id.averesTv);
        obl = root.findViewById(R.id.averageBtn);

        FloatingActionButton fab = root.findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                digits.setText("");
                String s = "Wynik";
                result.setText(s);
            }
        });

        obl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nums = digits.getText().toString().trim();
                CharSequence empty = "Nie podano danych";
                if (nums.isEmpty()) {
                    Toast toast = Toast.makeText(getContext(), empty, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    int sum = 0;
                    for (int i=0; i<nums.length(); i++) {
                        char ch = nums.charAt(i);
                        int l = Integer.parseInt(String.valueOf(ch));
                        System.out.println("Liczba: + " + l);
                        System.out.println("Suma przed dodaniem + " + sum);
                        sum += l;
                        System.out.println("Suma po dodaniu: " + sum);
                    }
                    System.out.println("Koniec pętli");
                    double aver = (double) sum / nums.length();
                    System.out.println("Srednia: " + aver);
                    aver *= 100;
                    aver = Math.round(aver);
                    aver /= 100;
                    System.out.println("Po zaokrogleniu: " + aver);
                    String res = String.valueOf(aver);
                    result.setText(res);
                }
            }
        });
        return root;
    }
}
