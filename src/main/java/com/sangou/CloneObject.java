package com.sangou;

public class CloneObject implements Cloneable {
    private String str;

    public Dog dog;

    public CloneObject clone() throws CloneNotSupportedException {
        return (CloneObject) super.clone();
    }
}
