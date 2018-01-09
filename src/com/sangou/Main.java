package com.sangou;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Cake c = new Cake();
        c.callPie();

        Cartoon cartoon = new Cartoon();

        FinalData fd1 = new FinalData();
        //fd1.i1++;
        //FinalData.i2++;
        fd1.v1.i = 1;
        for (int i = 0; i < fd1.a.length; i++) {
            fd1.a[i]++;
        }
        //fd1.a = new int[]{1};
        fd1.print("fd1");

        FinalData fd2 = new FinalData();
        fd1.print("fd2");
        fd2.print("fd2");
    }
}
