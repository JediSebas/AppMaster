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

public class RandNums extends Fragment {

    EditText startEt, stopEt;
    TextView result;
    Button los;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_generliczb2, container, false);
        startEt = root.findViewById(R.id.startEt);
        stopEt = root.findViewById(R.id.stopEt);
        result = root.findViewById(R.id.generrandresTv);
        los = root.findViewById(R.id.generlosBtn);

        los.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String starts, stops, ress;
                int s1 = 0, s2 = s1 + 1, res;
                try{
                    starts = startEt.getText().toString().trim();
                    s1 = Integer.parseInt(starts);
                }catch (NumberFormatException e){startEt.setText("0");}
                try{
                    stops = stopEt.getText().toString().trim();
                    s2 = Integer.parseInt(stops);
                }catch (NumberFormatException e){
                    s2 = s1 + 1;
                    String er = Integer.toString(s2);
                    stopEt.setText(er);
                }
                finally {
                    if (s1 < s2) {
                        res = (int) (Math.random() * (s2 - s1 + 1) + s1);
                    }else {
                        res = (int) (Math.random() * (s1 - s2 + 1) + s2);
                    }
                    ress = Integer.toString(res);
                    result.setText(ress);
                }
            }
        });
        return root;
    }
}
