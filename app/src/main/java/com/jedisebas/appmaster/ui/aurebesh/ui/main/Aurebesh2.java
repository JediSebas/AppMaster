package com.jedisebas.appmaster.ui.aurebesh.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jedisebas.appmaster.R;

public class Aurebesh2 extends Fragment {

    EditText input, output;
    ImageView img;
    Button repl, clear;
    Switch aSwitch;

    String change(String reple) {
        int i;
        String str = reple;
        for (i=0; i<str.length(); i++){
            switch (str.charAt(i)){
                case 'ś':
                    str = str.replace(str.charAt(i), 's');
                    break;
                case 'Ś':
                    str = str.replace(str.charAt(i), 'S');
                    break;
                case 'ć':
                    str = str.replace(str.charAt(i), 'c');
                    break;
                case 'Ć':
                    str = str.replace(str.charAt(i), 'C');
                    break;
                case 'ż':
                case 'ź':
                    str = str.replace(str.charAt(i), 'z');
                    break;
                case 'Ż':
                case 'Ź':
                    str = str.replace(str.charAt(i), 'Z');
                    break;
                case 'ł':
                    str = str.replace(str.charAt(i), 'l');
                    break;
                case 'Ł':
                    str = str.replace(str.charAt(i), 'L');
                    break;
                case 'ó':
                    str = str.replace(str.charAt(i), 'o');
                    break;
                case 'Ó':
                    str = str.replace(str.charAt(i), 'O');
                    break;
                case 'ę':
                    str = str.replace(str.charAt(i), 'e');
                    break;
                case 'Ę':
                    str = str.replace(str.charAt(i), 'E');
                    break;
                case 'ą':
                    str = str.replace(str.charAt(i), 'a');
                    break;
                case 'Ą':
                    str = str.replace(str.charAt(i), 'A');
                    break;
                case 'ń':
                    str = str.replace(str.charAt(i), 'n');
                    break;
                case 'Ń':
                    str = str.replace(str.charAt(i), 'N');
                    break;
            }
        }
        return str;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_aurebesh2, container, false);

        input = root.findViewById(R.id.aurebesh1Et);
        output = root.findViewById(R.id.aurebesh2Et);
        img = root.findViewById(R.id.aurebeshalphabet);
        aSwitch = root.findViewById(R.id.aurebeshswitch);
        repl = root.findViewById(R.id.aurebeshBtn);
        clear = root.findViewById(R.id.aurebeshclearBtn);

        img.setVisibility(View.GONE);

        aSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                img.setVisibility(View.VISIBLE);
            }else {
                img.setVisibility(View.GONE);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("");
                output.setText("");
            }
        });

        repl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String in, out;
                in = input.getText().toString().trim();
                in = change(in);
                if (in.isEmpty()) {
                    out = output.getText().toString().trim();
                    out = change(out);
                    output.setText(out);
                    input.setText(out);
                } else {
                    output.setText(in);
                    input.setText(in);
                }
            }
        });




        return root;
    }
}
