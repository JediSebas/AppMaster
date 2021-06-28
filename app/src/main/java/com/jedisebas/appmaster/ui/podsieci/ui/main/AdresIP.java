package com.jedisebas.appmaster.ui.podsieci.ui.main;

public class AdresIP {
    String adres;
    int[] decAdres = {0, 0, 0, 0};
    String[] strAdres = {"", "", "", ""};
    String[] binary = {"00000000", "00000000", "00000000", "00000000"};

    public AdresIP(String str) {
        adres = str;
        strToArray();
        strToDec();
        decToBin();
    }

    AdresIP() {
        adres = "0.0.0.0";
    }

    void strToArray() {
        int j = 0;
        for (int i = 0; i < adres.length(); i++) {
            if (adres.charAt(i) == '.') {
                j++;
                continue;
            }
            strAdres[j] += adres.charAt(i);
        }
    }

    void strToDec() {
        for (int i = 0; i < strAdres.length; i++) {
            decAdres[i] = Integer.parseInt(strAdres[i]);
        }
    }

    void decToBin() {
        for (int i = 0; i < decAdres.length; i++) {
            String bin = "";
            if (decAdres[i] > 127) {
                bin = Integer.toBinaryString(decAdres[i]);
            } else if (decAdres[i] > 63) {
                bin = "0" + Integer.toBinaryString(decAdres[i]);
            } else if (decAdres[i] > 31) {
                bin = "00" + Integer.toBinaryString(decAdres[i]);
            } else if (decAdres[i] > 15) {
                bin = "000" + Integer.toBinaryString(decAdres[i]);
            } else if (decAdres[i] > 7) {
                bin = "0000" + Integer.toBinaryString(decAdres[i]);
            } else if (decAdres[i] > 3) {
                bin = "00000" + Integer.toBinaryString(decAdres[i]);
            } else if (decAdres[i] > 1) {
                bin = "000000" + Integer.toBinaryString(decAdres[i]);
            } else if (decAdres[i] == 1) {
                bin = "0000000" + Integer.toBinaryString(decAdres[i]);
            } else if (decAdres[i] == 0) {
                bin = "00000000";
            }
            binary[i] = bin;
        }
    }

    void showStrAdres() {
        for (String s : strAdres) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    void showDecAdres() {
        for (int i : decAdres) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    void showBinary() {
        for (String s : binary) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
