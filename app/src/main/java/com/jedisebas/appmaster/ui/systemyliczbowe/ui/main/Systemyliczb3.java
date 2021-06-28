package com.jedisebas.appmaster.ui.systemyliczbowe.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jedisebas.appmaster.R;

public class Systemyliczb3 extends Fragment {

    EditText binEt, zmEt, uoEt, utEt;
    Button obl, clear;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_systemyliczb3, container, false);
        binEt = root.findViewById(R.id.norbinEt);
        zmEt = root.findViewById(R.id.zmEt);
        uoEt = root.findViewById(R.id.uoEt);
        utEt = root.findViewById(R.id.utEt);
        obl = root.findViewById(R.id.sysliczb3Btn);
        clear = root.findViewById(R.id.sysliczb3clearBtn);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binEt.setText("");
                zmEt.setText("");
                uoEt.setText("");
                utEt.setText("");
            }
        });

        obl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    convertBinaryNums(binEt, zmEt, uoEt, utEt);
                } catch (IsEmptyException e) {
                    e.printStackTrace();
                }
            }
        });

        return root;
    }

    public void binToZm(EditText bin, EditText zm) {
        String binaryStr = bin.getText().toString().trim();
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i < binaryStr.length(); i++) {
                out += binaryStr.charAt(i);
            }
            zm.setText(out);
        } else {
            zm.setText("0" + binaryStr);
        }
    }

    public void binToUo(EditText bin, EditText uo) {
        String binaryStr = bin.getText().toString().trim();
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i<binaryStr.length(); i++) {
                if (binaryStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            out = "0" + binaryStr;
        }
        uo.setText(out);
    }

    public void binToUt(EditText bin, EditText ut) {
        String binaryStr = bin.getText().toString().trim();
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i<binaryStr.length(); i++) {
                if (binaryStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            out = "0" + binaryStr;
        }
        int decimal=Integer.parseInt(out,2);
        decimal++;
        if (binaryStr.charAt(0) == '-') {
            ut.setText(Integer.toBinaryString(decimal));
        } else {
            ut.setText("0" + Integer.toBinaryString(decimal));
        }
    }

    public void zmToBin(EditText zm, EditText bin) {
        String zmStr = zm.getText().toString().trim();
        String out = "";
        if (zmStr.charAt(0) == '1') {out += "-";}
        for (int i=1; i<zmStr.length(); i++) {
            out += zmStr.charAt(i);
        }
        bin.setText(out);
    }

    public void zmToUo(EditText zm, EditText uo) {
        String zmStr = zm.getText().toString().trim();
        String binaryStr = "";
        if (zmStr.charAt(0) == '1') {binaryStr += "-";}
        for (int i=1; i<zmStr.length(); i++) {
            binaryStr += zmStr.charAt(i);
        }
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i<binaryStr.length(); i++) {
                if (binaryStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            out = "0" + binaryStr;
        }
        uo.setText(out);
    }

    public void zmToUt(EditText zm, EditText ut) {
        String zmStr = zm.getText().toString().trim();
        String binaryStr = "";
        if (zmStr.charAt(0) == '1') {binaryStr += "-";}
        for (int i=1; i<zmStr.length(); i++) {
            binaryStr += zmStr.charAt(i);
        }
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i<binaryStr.length(); i++) {
                if (binaryStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            out = "0" + binaryStr;
        }
        int decimal=Integer.parseInt(out,2);
        decimal++;
        if (binaryStr.charAt(0) == '-') {
            ut.setText(Integer.toBinaryString(decimal));
        } else {
            ut.setText("0" + Integer.toBinaryString(decimal));
        }
    }

    public void uoToBin(EditText uo, EditText bin) {
        String uoStr = uo.getText().toString().trim();
        String out = "";
        if (uoStr.charAt(0) == '1') {
            out += "-";
            for (int i = 1; i<uoStr.length(); i++) {
                if (uoStr.charAt(i) == '0') {
                    out += "1";
                } else {
                    out += "0";
                }
            }
        } else {
            for (int i = 1; i<uoStr.length(); i++) {
                out += uoStr.charAt(i);
            }
        }
        bin.setText(out);
    }

    public void uoToZm(EditText uo, EditText zm) {
        String uoStr = uo.getText().toString().trim();
        String binaryStr = "";
        if (uoStr.charAt(0) == '1') {
            binaryStr += "-";
            for (int i = 1; i<uoStr.length(); i++) {
                if (uoStr.charAt(i) == '0') {
                    binaryStr += "1";
                } else {
                    binaryStr += "0";
                }
            }
        } else {
            for (int i = 1; i<uoStr.length(); i++) {
                binaryStr += uoStr.charAt(i);
            }
        }
        String out = "";
        if (binaryStr.charAt(0) == '-') {
            out += "1";
            for (int i = 1; i < binaryStr.length(); i++) {
                out += binaryStr.charAt(i);
            }
            zm.setText(out);
        } else {
            zm.setText("0" + binaryStr);
        }
    }

    public void uoToUt(EditText uo, EditText ut) {
        String uoStr = uo.getText().toString().trim();
        int decimal=Integer.parseInt(uoStr,2);
        decimal++;
        if (uoStr.charAt(0) == '1') {
            ut.setText(Integer.toBinaryString(decimal));
        } else {
            ut.setText("0" + Integer.toBinaryString(decimal));
        }
    }

    public void utToUo(EditText ut, EditText uo) {
        String utStr = ut.getText().toString().trim();
        int decimal=Integer.parseInt(utStr,2);
        decimal--;
        if (utStr.charAt(0) == '1') {
            uo.setText(Integer.toBinaryString(decimal));
        } else {
            uo.setText("0" + Integer.toBinaryString(decimal));
        }
    }

    public void convertBinaryNums(EditText bin, EditText zm, EditText uo, EditText ut) throws IsEmptyException {
        try {
            String str = bin.getText().toString().trim();
            if (str.isEmpty())
                throw new IsEmptyException();
            binToZm(bin, zm);
            binToUo(bin, uo);
            binToUt(bin, ut);
        } catch (IsEmptyException e) {
            try {
                String str = zm.getText().toString().trim();
                if (str.isEmpty())
                    throw new IsEmptyException();
                zmToBin(zm, bin);
                zmToUo(zm, uo);
                zmToUt(zm, ut);
            } catch (IsEmptyException e2) {
                try {
                    String str = uo.getText().toString().trim();
                    if (str.isEmpty())
                        throw new IsEmptyException();
                    uoToBin(uo, bin);
                    uoToZm(uo, zm);
                    uoToUt(uo, ut);
                } catch (IsEmptyException e3) {
                    try {
                        String str = ut.getText().toString().trim();
                        if (str.isEmpty())
                            throw new IsEmptyException();
                        utToUo(ut, uo);
                        uoToBin(uo, bin);
                        uoToZm(uo, zm);
                    } catch (IsEmptyException e4) {
                        bin.setText("-101");
                        zm.setText("1101");
                        uo.setText("1010");
                        ut.setText("1011");
                    }
                }
            }
        }
    }
}
