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

public class Wspol extends Fragment {

    EditText axet, ayet, bxet, byet, cxet, cyet;
    TextView wzor1, wzor2, res1, res2;
    Button obl;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_liniowa3, container, false);

        axet = root.findViewById(R.id.wspolAXEt);
        ayet = root.findViewById(R.id.wspolAYEt);
        bxet = root.findViewById(R.id.wspolBXEt);
        byet = root.findViewById(R.id.wspolBYEt);
        cxet = root.findViewById(R.id.wspolCXEt);
        cyet = root.findViewById(R.id.wspolCYEt);
        wzor1 = root.findViewById(R.id.wspolwzor1Tv);
        wzor2 = root.findViewById(R.id.wspolwzor2Tv);
        res1 = root.findViewById(R.id.wspolres1Tv);
        res2 = root.findViewById(R.id.wspolres2Tv);
        obl = root.findViewById(R.id.wspolBtn);

        String s = "y - y1 = [(y2 - y1)/(x2 - x1)] * (x - x1)";
        String s2 = "L = P";
        String s3 = "TAK / NIE";
        wzor1.setText(s);
        wzor2.setText(s);
        res1.setText(s2);
        res2.setText(s3);

        FloatingActionButton fab = root.findViewById(R.id.floatingActionButton4);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axet.setText("");
                ayet.setText("");
                bxet.setText("");
                byet.setText("");
                cxet.setText("");
                cyet.setText("");
                wzor2.setText(s);
                res1.setText(s2);
                res2.setText(s3);
            }
        });


        obl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String axs = axet.getText().toString().trim();
                String ays = ayet.getText().toString().trim();
                String bxs = bxet.getText().toString().trim();
                String bys = byet.getText().toString().trim();
                String cxs = cxet.getText().toString().trim();
                String cys = cyet.getText().toString().trim();
                CharSequence empty = "Nie podano wszystkiego";
                if (axs.isEmpty() || ays.isEmpty() || bxs.isEmpty() ||
                        bys.isEmpty() || cxs.isEmpty() || cys.isEmpty()) {
                    Toast toast = Toast.makeText(getContext(), empty, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    double ax = Double.parseDouble(axs);
                    double ay = Double.parseDouble(ays);
                    double bx = Double.parseDouble(bxs);
                    double by = Double.parseDouble(bys);
                    double cx = Double.parseDouble(cxs);
                    double cy = Double.parseDouble(cys);

                    double a, b;
                    a = cy - ay;
                    b = ((by - ay)/(bx - ax)) * (cx - ax);
                    a *= 10000;
                    a = Math.round(a);
                    a /= 10000;
                    b *= 10000;
                    b = Math.round(b);
                    b /= 10000;
                    wzor2.setText(cy + " - " + ay + " = " + "[(" + by + " - " + ay + ")/(" + bx + " - " + ax + ")] * (" + cx + " - " + ax + ")");
                    res1.setText(a + " = " + b);
                    if (a == b){
                        res2.setText("TAK");
                    }else if (a != b){
                        res2.setText("NIE");
                    }
                }
            }
        });

        return root;
    }
}
