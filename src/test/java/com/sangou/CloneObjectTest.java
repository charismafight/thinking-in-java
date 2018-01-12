package com.sangou;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CloneObjectTest {
    @Test
    public void cloneObjTest() throws CloneNotSupportedException {
        CloneObject co1 = new CloneObject();
        CloneObject co2 = co1.clone();
        // assertequals actually execute co1==co2
        assertNotEquals(co1, co2);
        co1.dog = new Dog(5);
        co2 = co1.clone();
        // clone() is shallow copy
        assertEquals(co2.dog, co1.dog);
    }
}