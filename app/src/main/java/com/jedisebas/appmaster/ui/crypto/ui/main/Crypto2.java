package com.jedisebas.appmaster.ui.crypto.ui.main;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jedisebas.appmaster.R;

import static android.content.Context.CLIPBOARD_SERVICE;

public class Crypto2 extends Fragment {

    EditText originEt, ciphredEt;
    Button repl, clear, copy;

    private ClipboardManager myClipboard;
    private ClipData myClip;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_crypto2, container, false);
        originEt = root.findViewById(R.id.rot13originEt);
        ciphredEt = root.findViewById(R.id.rot12ciphredEt);
        repl = root.findViewById(R.id.rot13Btn);
        clear = root.findViewById(R.id.rot13clearBtn);
        copy = root.findViewById(R.id.rot13copyBtn);

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
            }
        });

        repl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String origin, ciphred;
                origin = originEt.getText().toString().trim();
                if (origin.isEmpty()) {
                    ciphred = ciphredEt.getText().toString().trim();
                    ciphred = ciphring(ciphred);
                    originEt.setText(ciphred);
                } else {
                    origin = ciphring(origin);
                    ciphredEt.setText(origin);
                }
            }
        });
        return root;
    }

    String ciphring(String orig) {
        StringBuilder result = new StringBuilder();
        for (int i =0; i<orig.length(); i++) {
            switch (orig.charAt(i)) {
                case 'a':
                    result.append('n');
                    break;
                case 'b':
                    result.append('o');
                    break;
                case 'c':
                    result.append('p');
                    break;
                case 'd':
                    result.append('q');
                    break;
                case 'e':
                    result.append('r');
                    break;
                case 'f':
                    result.append('s');
                    break;
                case 'g':
                    result.append('t');
                    break;
                case 'h':
                    result.append('u');
                    break;
                case 'i':
                    result.append('v');
                    break;
                case 'j':
                    result.append('w');
                    break;
                case 'k':
                    result.append('x');
                    break;
                case 'l':
                    result.append('y');
                    break;
                case 'm':
                    result.append('z');
                    break;
                case 'n':
                    result.append('a');
                    break;
                case 'o':
                    result.append('b');
                    break;
                case 'p':
                    result.append('c');
                    break;
                case 'q':
                    result.append('d');
                    break;
                case 'r':
                    result.append('e');
                    break;
                case 's':
                    result.append('f');
                    break;
                case 't':
                    result.append('g');
                    break;
                case 'u':
                    result.append('h');
                    break;
                case 'v':
                    result.append('i');
                    break;
                case 'w':
                    result.append('j');
                    break;
                case 'x':
                    result.append('k');
                    break;
                case 'y':
                    result.append('l');
                    break;
                case 'z':
                    result.append('m');
                    break;
                case 'A':
                    result.append('N');
                    break;
                case 'B':
                    result.append('O');
                    break;
                case 'C':
                    result.append('P');
                    break;
                case 'D':
                    result.append('Q');
                    break;
                case 'E':
                    result.append('R');
                    break;
                case 'F':
                    result.append('S');
                    break;
                case 'G':
                    result.append('T');
                    break;
                case 'H':
                    result.append('U');
                    break;
                case 'I':
                    result.append('V');
                    break;
                case 'J':
                    result.append('W');
                    break;
                case 'K':
                    result.append('X');
                    break;
                case 'L':
                    result.append('Y');
                    break;
                case 'M':
                    result.append('Z');
                    break;
                case 'N':
                    result.append('A');
                    break;
                case 'O':
                    result.append('B');
                    break;
                case 'P':
                    result.append('C');
                    break;
                case 'Q':
                    result.append('D');
                    break;
                case 'R':
                    result.append('E');
                    break;
                case 'S':
                    result.append('F');
                    break;
                case 'T':
                    result.append('G');
                    break;
                case 'U':
                    result.append('H');
                    break;
                case 'V':
                    result.append('I');
                    break;
                case 'W':
                    result.append('J');
                    break;
                case 'X':
                    result.append('K');
                    break;
                case 'Y':
                    result.append('L');
                    break;
                case 'Z':
                    result.append('M');
                    break;
                default:
                    result.append(orig.charAt(i));
            }
        }
        return result.toString();
    }

}
