package com.jedisebas.appmaster.ui.podsieci.ui.main;

public class Maska extends AdresIP {
    int ones_amount;

    public Maska(String str) {
        super(str);
        strToArray();
        countOnes();
    }

    public Maska() {
        adres = "0.0.0.0";
    }

    private void normalMasc(int n, int w) {
        int x = n % 8;
        switch (x) {
            case 0:
                strAdres[w] = "0";
                break;
            case 1:
                strAdres[w] = "128";
                break;
            case 2:
                strAdres[w] = "192";
                break;
            case 3:
                strAdres[w] = "224";
                break;
            case 4:
                strAdres[w] = "240";
                break;
            case 5:
                strAdres[w] = "248";
                break;
            case 6:
                strAdres[w] = "252";
                break;
            case 7:
                strAdres[w] = "254";
                break;
        }

    }

    void strToArray() {
        int j = 0;
        if (adres.charAt(0) == '/'){
            String cos = "";
            int num = 0;
            for (int i = 1; i < adres.length(); i++) {
                cos += adres.charAt(i);
            }
            num = Integer.parseInt(cos);
            if (num >= 24) {
                strAdres[0] = "255";
                strAdres[1] = "255";
                strAdres[2] = "255";
                normalMasc(num, 3);
            } else if (num >= 16){
                strAdres[0] = "255";
                strAdres[1] = "255";
                normalMasc(num, 2);
                strAdres[3] = "0";
            } else if (num >= 8) {
                strAdres[0] = "255";
                normalMasc(num, 1);
                strAdres[2] = "0";
                strAdres[3] = "0";
            } else if (num >= 0) {
                normalMasc(num, 0);
                strAdres[1] = "0";
                strAdres[2] = "0";
                strAdres[3] = "0";
            }
        }
        else {
            for (int i = 0; i < adres.length(); i++) {
                if (adres.charAt(i) == '.') {
                    j++;
                    continue;
                }
                strAdres[j] += adres.charAt(i);
            }
        }
    }

    void countOnes() {
        int count = 0;
        if (adres.charAt(0) == '/') {
            String cos = "";
            for (int i = 1; i < adres.length(); i++) {
                cos += adres.charAt(i);
            }
            ones_amount = Integer.parseInt(cos);
        }
        else {
            for (int i = 0; i < binary.length; i++) {
                for (int j = 0; j < binary[i].length(); j++) {
                    if (binary[i].charAt(j) == '1'){
                        count++;
                    }
                }
            }
            ones_amount = count;
        }
    }
}
