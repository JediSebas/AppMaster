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

public class PrzPkt extends Fragment {

    EditText x1Et, x2Et, y1Et, y2Et;
    TextView res;
    Button obl;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_liniowa5, container, false);
        x1Et = root.findViewById(R.id.przpktX1Et);
        x2Et = root.findViewById(R.id.przpktX2Et);
        y1Et = root.findViewById(R.id.przpktY1Et);
        y2Et = root.findViewById(R.id.przpktY2Et);
        res = root.findViewById(R.id.przpktresTv);
        obl = root.findViewById(R.id.przpktBtn);

        String s = "y = ax + b";
        res.setText(s);

        FloatingActionButton fab = root.findViewById(R.id.floatingActionButton7);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                x1Et.setText("");
                x2Et.setText("");
                y1Et.setText("");
                y2Et.setText("");
                res.setText(s);
            }
        });

        obl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x1s = x1Et.getText().toString().trim();
                String x2s = x2Et.getText().toString().trim();
                String y1s = y1Et.getText().toString().trim();
                String y2s = y2Et.getText().toString().trim();
                CharSequence empty = "Nie podano wszystkiego";
                CharSequence er = "Dane spowodowały bład";

                if (x1s.isEmpty() || x2s.isEmpty() || y1s.isEmpty() || y2s.isEmpty()) {
                    Toast toast = Toast.makeText(getContext(), empty, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double x1 = Double.parseDouble(x1s);
                    double x2 = Double.parseDouble(x2s);
                    double y1 = Double.parseDouble(y1s);
                    double y2 = Double.parseDouble(y2s);
                    double a, b;
                    try {
                        a = (y2 - y1) / (x2 - x1);
                        b = (a * -x1) + y1;
                        a *= 1000;
                        a = Math.round(a);
                        a /= 1000;
                        b *= 1000;
                        b = Math.round(b);
                        b /= 1000;
                        if (b > 0){
                            res.setText("y = " + a + "x + " + b);
                        }else if (b < 0){
                            res.setText("y = " + a + "x - " + Math.abs(b));
                        }else if (b == 0){
                            res.setText("y = " + a + "x");
                        }else{
                            res.setText("y = ax + b");
                        }
                    }catch (Exception e){
                        Toast toast = Toast.makeText(getContext(), er, Toast.LENGTH_LONG);
                        toast.show();
                    }
                }
            }
        });
        return root;
    }
}
