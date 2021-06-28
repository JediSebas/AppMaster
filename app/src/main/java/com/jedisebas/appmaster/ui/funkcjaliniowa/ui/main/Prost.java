package com.jedisebas.appmaster.ui.funkcjaliniowa.ui.main;

import android.graphics.Color;
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
import com.google.android.material.snackbar.Snackbar;
import com.jedisebas.appmaster.R;

public class Prost extends Fragment {

    EditText aEt, xEt, yEt;
    Button obl;
    TextView res;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_liniowa4, container, false);
        aEt = root.findViewById(R.id.prostAEt);
        xEt = root.findViewById(R.id.prostXEt);
        yEt = root.findViewById(R.id.prostYEt);
        obl = root.findViewById(R.id.prostBtn);
        res = root.findViewById(R.id.prostresTv);

        String s = "y = ax + b";
        res.setText(s);

        FloatingActionButton fab = root.findViewById(R.id.floatingActionButton6);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "x i y odnoszą się od punktu P(x, y)", Snackbar.LENGTH_LONG);
                View snackbarView = snackbar.getView();
                TextView textView = (TextView) snackbarView.findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.WHITE);
                snackbar.show();
            }
        });

        FloatingActionButton fab2 = root.findViewById(R.id.floatingActionButton5);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aEt.setText("");
                xEt.setText("");
                yEt.setText("");
                res.setText(s);
            }
        });

        obl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String as = aEt.getText().toString().trim();
                String xs = xEt.getText().toString().trim();
                String ys = yEt.getText().toString().trim();
                CharSequence empty = "Nie podano wszystkiego";
                CharSequence zero = "Parametr a nie może być zerem";
                if (as.isEmpty() || xs.isEmpty() || ys.isEmpty()) {
                    Toast toast = Toast.makeText(getContext(), empty, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double a = Double.parseDouble(as);
                    double x = Double.parseDouble(xs);
                    double y = Double.parseDouble(ys);
                    double ap, b;

                    if (a == 0){
                        Toast toast = Toast.makeText(getContext(), zero, Toast.LENGTH_LONG);
                        toast.show();
                        aEt.setText("1");
                        a = 1;
                    }

                    ap = -1/a;
                    b = y - ap*x;
                    ap *= 1000;
                    ap = Math.round(ap);
                    ap /= 1000;
                    b *= 1000;
                    b = Math.round(b);
                    b /= 1000;
                    if (b > 0){
                        res.setText("y = " + ap + "x + " + b);
                    }else if (b < 0){
                        res.setText("y = " + ap + "x - " + Math.abs(b));
                    }else if (b == 0){
                        res.setText("y = " + ap + "x");
                    }
                }
            }
        });
        return root;
    }
}
