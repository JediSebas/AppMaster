package com.jedisebas.appmaster.ui.crypto.ui.main;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.jedisebas.appmaster.R;

import static android.content.Context.CLIPBOARD_SERVICE;

public class Crypto3 extends Fragment {

    EditText originEt, ciphredEt, keyEt;
    Button szyfr, clear, copy;
    char[] alphabet = {'a', 'ą', 'b', 'c', 'ć', 'd', 'e', 'ę', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
                        'ł', 'm', 'n', 'ń', 'o', 'ó', 'p', 'q', 'r', 's', 'ś', 't', 'u', 'v', 'w',
                            'x', 'y', 'z', 'ź', 'ż'};
    char[][] tabulaRecta = new char[alphabet.length+1][alphabet.length+1];

    private ClipboardManager myClipboard;
    private ClipData myClip;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_crypto3, container, false);
        originEt = root.findViewById(R.id.viegoriginEt);
        ciphredEt = root.findViewById(R.id.viegciphredEt);
        keyEt = root.findViewById(R.id.viegkeyEt);
        szyfr = root.findViewById(R.id.viegBtn);
        clear = root.findViewById(R.id.viegclearBtn);
        copy = root.findViewById(R.id.viegcopyBtn);

        fillTabulaRecta();

        copy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClipboard = (ClipboardManager) getContext().getSystemService(CLIPBOARD_SERVICE);
                String text;
                text = ciphredEt.getText().toString();

                myClip = ClipData.newPlainText("text", text);
                myClipboard.setPrimaryClip(myClip);

                CharSequence charSequence = "Skopiowano do schowka";
                Toast.makeText(getContext(), charSequence,Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                originEt.setText("");
                ciphredEt.setText("");
                keyEt.setText("");
            }
        });

        szyfr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String origin, ciphred, key;
                origin = originEt.getText().toString().trim();
                key = keyEt.getText().toString().trim();
                key = key.toLowerCase();
                CharSequence empty = "Nie podano klucza";
                if (key.isEmpty()) {
                    Toast toast = Toast.makeText(getContext(), empty, Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    if (origin.isEmpty()) {
                        ciphred = ciphredEt.getText().toString().trim();
                        ciphred = ciphred.toLowerCase();
                        ciphredEt.setText(ciphred);
                        originEt.setText(decrypt(ciphred, key));
                    } else {
                        origin = origin.toLowerCase();
                        originEt.setText(origin);
                        ciphredEt.setText(encrypt(origin, key));
                    }
                }
            }
        });

        return root;
    }

    StringBuilder decrypt(String ciphr, String key) {
        StringBuilder origin = new StringBuilder();
        int j=0;
        for (int i=0; i<ciphr.length(); i++) {
            if (j >= key.length()) { j = 0; }
            int l1 = returnNum(ciphr.charAt(i));
            int l2 = returnNum(key.charAt(j));
            if (l1 == -1) {
                origin.append(ciphr.charAt(i));
            } else {
                j++;
                char[] ch = tabulaRecta[l2];
                for (int k = 0; k < ch.length; k++) {
                    int x = returnNum(ch[k]);
                    if (x == l1) {
                        origin.append(tabulaRecta[0][k]);
                    }
                }
            }
        }
        return origin;
    }

    StringBuilder encrypt(String origin, String key) {
        StringBuilder ciphred = new StringBuilder();
        int j =0;
        for (int i=0; i<origin.length(); i++) {
            if (j >= key.length()) { j = 0; }
            int l1 = returnNum(origin.charAt(i));
            int l2 = returnNum(key.charAt(j));
            if (l1 == -1) {
                ciphred.append(origin.charAt(i));
            } else {
                j++;
                char ch = tabulaRecta[l1][l2];
                ciphred.append(ch);
            }
        }
        return ciphred;
    }

    void fillTabulaRecta() {
        for (int i=0; i < alphabet.length; i++) {
            int k = 0;
            for (int j = i; k < alphabet.length; j++) {
                if (j >= alphabet.length) {
                    j = 0;
                }
                tabulaRecta[i][k] = alphabet[j];
                k++;
            }
        }
    }

    static int returnNum(char ch) {
        switch (ch) {
            case 'a':
                return 0;
            case 'ą':
                return 1;
            case 'b':
                return 2;
            case 'c':
                return 3;
            case 'ć':
                return 4;
            case 'd':
                return 5;
            case 'e':
                return 6;
            case 'ę':
                return 7;
            case 'f':
                return 8;
            case 'g':
                return 9;
            case 'h':
                return 10;
            case 'i':
                return 11;
            case 'j':
                return 12;
            case 'k':
                return 13;
            case 'l':
                return 14;
            case 'ł':
                return 15;
            case 'm':
                return 16;
            case 'n':
                return 17;
            case 'ń':
                return 18;
            case 'o':
                return 19;
            case 'ó':
                return 20;
            case 'p':
                return 21;
            case 'q':
                return 22;
            case 'r':
                return 23;
            case 's':
                return 24;
            case 'ś':
                return 25;
            case 't':
                return 26;
            case 'u':
                return 27;
            case 'v':
                return 28;
            case 'w':
                return 29;
            case 'x':
                return 30;
            case 'y':
                return 31;
            case 'z':
                return 32;
            case 'ź':
                return 33;
            case 'ż':
                return 34;
            default:
                return -1;
        }
    }
}
