package com.sangou;

public class FinalData {
    final int i1 = 9;
    static final int i2 = 99;
    public static final int i3 = 39;


    final int i4;

    {
        i4 = (int) (Math.random() * 20);
    }

    static final int i5;

    static {
        i5 = (int) (Math.random() * 20);
    }


    Value v1 = new Value();
    final Value v2 = new Value();
    static final Value v3 = new Value();

//    final Value v4;

    final int[] a = {1, 2, 3, 4, 5};

    public void print(String id) {
        System.out.println(id + ":" + "i4=" + i4 + ",i5=" + i5);
        System.out.println("i5=" + FinalData.i5);
    }
}


class Value {
    int i = 1;
}

