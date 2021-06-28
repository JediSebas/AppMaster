package com.jedisebas.appmaster.ui.generliczb.ui.main;

public class GenPrime implements Runnable {

    public Thread t;
    int m=1;

    public GenPrime(int num) {
        t = new Thread(this, "Prime Generating");
        m = num;
    }

    @Override
    public void run() {
        int input, whichNumber = 0, i, j, first = 2;
        input = m;
        for (i = 2; input != whichNumber; i++) {
            for (j = 2; j < i + 1; j++) {
                if (i % j == 0) {
                    if (j == i) {
                        whichNumber++;
                        first = i;
                    }
                    break;
                }
            }
        }
        String si = Integer.toString(first);
        PrimeNums.setText(si);
    }
}
