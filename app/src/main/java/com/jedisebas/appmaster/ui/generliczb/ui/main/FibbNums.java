package com.jedisebas.appmaster.ui.generliczb.ui.main;

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

public class FibbNums extends Fragment {

    EditText fibbEt;
    TextView fibbTv;
    Button fibbBtn;

    void fibbonaci(EditText et, TextView tv) {
        int x = 1;
        try{
            x = Integer.parseInt(et.getText().toString().trim());
        }catch (NumberFormatException e){et.setText("1"); x=1;}
        finally {
            int input = x, whichNumber = 0;
            long i = 0, j, fib = 1;
            while (input != whichNumber) {
                j = fib;
                fib += i;
                i = j;
                whichNumber++;
            }
            String out = Long.toString(fib);
            tv.setText(out);
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_generliczb4, container, false);
        fibbEt = root.findViewById(R.id.fibbEt);
        fibbTv = root.findViewById(R.id.fibbTv);
        fibbBtn = root.findViewById(R.id.fibbBtn);

        fibbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fibbonaci(fibbEt, fibbTv);
            }
        });
        return root;
    }
}
