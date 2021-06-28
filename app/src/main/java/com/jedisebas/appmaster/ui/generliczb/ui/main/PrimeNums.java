package com.jedisebas.appmaster.ui.generliczb.ui.main;

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

import com.jedisebas.appmaster.R;

public class PrimeNums extends Fragment {

    EditText primeEt;
    static TextView primeTv;
    Button primeBtn;

    static String sett="";

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_generliczb3, container, false);
        primeEt = root.findViewById(R.id.primeEt);
        primeTv = root.findViewById(R.id.primeresTv);
        primeBtn = root.findViewById(R.id.primeBtn);

        primeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = "Generowanie...";
                Toast toast = Toast.makeText(getContext(), text, Toast.LENGTH_LONG);
                toast.show();
                String nums;
                int num=1;
                try {
                    nums = primeEt.getText().toString().trim();
                    num = Integer.parseInt(nums);
                }catch (NumberFormatException e){primeEt.setText("1"); num=1;}
                finally {
                    GenPrime genPrime = new GenPrime(num);
                    genPrime.t.start();
                    try {
                        genPrime.t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    primeTv.setText(sett);
                }
            }
        });
        return root;
    }
    static void setText(String str) {
        sett = str;
    }
}
