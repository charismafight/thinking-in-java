package com.sangou;

import java.util.Hashtable;

class Counter {
    int i = 1;

    @Override
    public String toString() {
        return Integer.toString(i);
    }
}

public class Statistics {
    public static void main(String[] args) {
        Hashtable<Integer, Counter> ht = new Hashtable();
        for (int d = 0; d < 10000; d++) {
            Integer integer = (int) (Math.random() * 20);
            if (ht.containsKey(integer)) {
                ht.get(integer).i += 1;
            } else {
                ht.put(integer, new Counter());
            }
        }
        System.out.println(ht);

        Hashtable ht2 = new Hashtable();
        ht2.put(10, 10);
        Object o = ht2.get(10);
        o = 11;
        ht2.put(10, o);
        System.out.println(ht2.get(10));
    }
}
