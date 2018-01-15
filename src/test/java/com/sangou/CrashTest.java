package com.sangou;

import org.junit.jupiter.api.Test;

import java.util.Vector;

//a test to making java crashed
public class CrashTest {
    @Test
    public void Crash() {
        CrashJava crashJava = new CrashJava();
        Vector vector = new Vector();
        for (int i = 0; i < 10; i++) {
            vector.addElement(new CrashJava());
        }
        System.out.println(vector);
    }
}
