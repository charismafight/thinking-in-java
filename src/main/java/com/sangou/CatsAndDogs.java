package com.sangou;

import java.util.BitSet;
import java.util.Vector;

public class CatsAndDogs {
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 5; i++) {
            v.add(new Cat(5));
        }
//        error here,on runtime
        //v.add(new Dog(9));
        for (int i = 0; i < 2; i++) {
            v.add(new Cat(2));
        }

        for (int i = 0; i < v.size(); i++) {
            ((Cat) v.get(i)).print();
        }
    }
}

class Cat {
    private int catNumber;

    Cat(int n) {
        catNumber = n;
    }

    void print() {
        System.out.println("cats");
    }
}

class Dog {
    private int dogNumber;

    Dog(int n) {
        dogNumber = n;
    }

    void print() {
        System.out.println("dogs");
    }
}

