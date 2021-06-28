package com.jedisebas.appmaster.ui.funkcjaliniowa.ui.main;

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

public class MiejZer extends Fragment {

    EditText aEt, bEt;
    TextView res1, res2;
    Button obl;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_liniowa2, container, false);

        aEt = root.findViewById(R.id.miejzerAEt);
        bEt = root.findViewById(R.id.miejzerBEt);
        res1 = root.findViewById(R.id.miejzerRes1);
        res2 = root.findViewById(R.id.miejzerRes2);
        obl = root.findViewById(R.id.miejzerBtn);

        String s1 = "y = 0 <=> x = ";
        String s2 = "x = 0 <=> y = ";

        res1.setText(s1);
        res2.setText(s2);

        FloatingActionButton fab = root.findViewById(R.id.floatingActionButton3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aEt.setText("");
                bEt.setText("");
                res1.setText(s1);
                res2.setText(s2);
            }
        });

        obl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String as = aEt.getText().toString().trim();
                String bs = bEt.getText().toString().trim();
                CharSequence empty = "Nie podano wszystkiego";
                CharSequence zero = "Parametr a nie może być zerem";
                if (as.isEmpty() || bs.isEmpty()) {
                    Toast toast = Toast.makeText(getContext(), empty, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double x, y;
                    double a = Double.parseDouble(as);
                    double b = Double.parseDouble(bs);
                    if (a == 0){
                        Toast toast = Toast.makeText(getContext(), zero, Toast.LENGTH_LONG);
                        toast.show();
                        aEt.setText("1");
                        a = 1;
                    }
                    x = -b/a;
                    x *= 1000;
                    x = Math.round(x);
                    x /= 1000;
                    y = b;
                    String r1 = "y = 0 <=> x = " + x;
                    String r2 = "x = 0 <=> y = " + y;
                    res1.setText(r1);
                    res2.setText(r2);
                }
            }
        });

        return root;
    }
}
