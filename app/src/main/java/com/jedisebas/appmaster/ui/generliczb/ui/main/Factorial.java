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

import java.math.BigInteger;

public class Factorial extends Fragment {

    EditText factorialEt;
    TextView factorialTv;
    Button factorialBtn;

    long fact(long n) {
        long result;

        if (n==1) return 1;
        result = fact(n-1) * n;
        return result;
    }

    void factorial(EditText et, TextView tv) {
        long x = 1;
        try{
            x = Long.parseLong(et.getText().toString().trim());
        }catch (NumberFormatException e){et.setText("1"); x=1;}
        finally {
            if (x == 0) {tv.setText("1");}
            else {
                String out = Long.toString(fact(x));
                tv.setText(out);
            }
        }
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_generliczb5, container, false);
        factorialEt = root.findViewById(R.id.factorialEt);
        factorialTv = root.findViewById(R.id.factorialTv);
        factorialBtn = root.findViewById(R.id.factorialBtn);

        factorialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                factorial(factorialEt, factorialTv);
            }
        });


        return root;
    }
}
