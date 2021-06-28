package com.jedisebas.appmaster.ui.funkcjakwadratowa.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jedisebas.appmaster.R;

public class Rownanie extends Fragment {

    EditText aEt, bEt, cEt;
    TextView res1, res2;
    Button obl;

    double zaokrl(double numb){
        numb *= 10000;
        numb = Math.round(numb);
        numb /= 10000;
        return numb;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_rownanie, container, false);
        aEt = root.findViewById(R.id.kwadrAEt);
        bEt = root.findViewById(R.id.kwadrBEt);
        cEt = root.findViewById(R.id.kwadrCEt);
        res1 = root.findViewById(R.id.kwadrres1Tv);
        res2 = root.findViewById(R.id.kwadrres2Tv);
        obl = root.findViewById(R.id.kwadrBtn);

        String s1 = "x1";
        String s2 = "x2";
        res1.setText(s1);
        res2.setText(s2);

        FloatingActionButton fab = root.findViewById(R.id.floatingActionButton10);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aEt.setText("");
                bEt.setText("");
                cEt.setText("");
                res1.setText(s1);
                res2.setText(s2);
            }
        });

        obl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String as = aEt.getText().toString().trim();
                String bs = bEt.getText().toString().trim();
                String cs = cEt.getText().toString().trim();
                CharSequence empty = "Nie podano wszystkiego";
                if (as.isEmpty() || bs.isEmpty() || cs.isEmpty()) {
                    Toast toast = Toast.makeText(getContext(), empty, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double a = Double.parseDouble(as);
                    double b = Double.parseDouble(bs);
                    double c = Double.parseDouble(cs);

                    double x1, x2;
                    double delta = pow(b, 2) - 4 * a * c;
                    if (a != 0 && b != 0 && c != 0) {
                        if (delta > 0) {
                            x1 = (-b + sqrt(delta)) / (2 * a);
                            x2 = (-b - sqrt(delta)) / (2 * a);
                            x1 = zaokrl(x1);
                            x2 = zaokrl(x2);
                            String wyn1 = String.valueOf(x1);
                            String wyn2 = String.valueOf(x2);
                            res1.setText(wyn1);
                            res2.setText(wyn2);
                        } else if (delta == 0) {
                            x1 = (-b) / (2 * a);
                            x1 = zaokrl(x1);
                            String wyn1 = String.valueOf(x1);
                            res1.setText(wyn1);
                            res2.setText("Brak");
                        } else if (delta < 0) {
                            double cz1 = -b / (2*a);
                            double cz2 = sqrt(-delta)/ (2*a);
                            cz1 = zaokrl(cz1);
                            cz2 = zaokrl(cz2);
                            String cz1s = String.valueOf(cz1);
                            String cz2s = String.valueOf(cz2);
                            if (cz2 == 1.0 || cz2 == -1.0){
                                res1.setText(cz1s + " + " + "i");
                                res2.setText(cz1s + " - " + "i");
                            }
                            else {
                                res1.setText(cz1s + " + " + cz2s + "i");
                                res2.setText(cz1s + " - " + cz2s + "i");
                            }
                        }
                    } else if (b == 0 && a != 0 && c != 0) {
                        if ((c < 0 || a < 0) && !(c < 0 && a < 0)) {
                            x1 = sqrt(-(c / a));
                            x2 = -(sqrt(-(c / a)));
                            x1 = zaokrl(x1);
                            x2 = zaokrl(x2);
                            String wyn1 = String.valueOf(x1);
                            String wyn2 = String.valueOf(x2);
                            res1.setText(wyn1);
                            res2.setText(wyn2);
                        } else if ((c < 0 && a < 0) || (c > 0 && a > 0)) {
                            double cz1 = sqrt(c/a);
                            double cz2 = -sqrt(c/a);
                            cz1 = zaokrl(cz1);
                            cz2 = zaokrl(cz2);
                            String cz1s = String.valueOf(cz1);
                            String cz2s = String.valueOf(cz2);
                            if (cz2 == 1.0 || cz2 == -1.0){
                                res1.setText("i");
                                res2.setText("-i");
                            }
                            else {
                                res1.setText(cz1s + "i");
                                res2.setText(cz2s + "i");
                            }
                        }
                    } else if (c == 0 && a != 0 && b != 0) {
                        x2 = -b / a;
                        x2 = zaokrl(x2);
                        String wyn2 = String.valueOf(x2);
                        res1.setText("0");
                        res2.setText(wyn2);
                    } else if (a == 0 && b == 0 && c == 0) {
                        res1.setText("0");
                        res2.setText("0");
                    } else if (a == 0 && c == 0 && b != 0) {
                        res1.setText("0");
                        res2.setText("0");
                    } else if (a != 0 && b == 0 && c == 0) {
                        res1.setText("0");
                        res2.setText("0");
                    } else if (a == 0 && b == 0 && c != 0) {
                        res1.setText("Brak");
                        res2.setText("Brak");
                    } else if (a == 0 && b != 0 && c != 0) {
                        x1 = -(c / b);
                        x1 = zaokrl(x1);
                        String wyn1 = String.valueOf(x1);
                        res1.setText(wyn1);
                        res2.setText("Brak");
                    }
                }
            }
        });
        return root;
    }
}
