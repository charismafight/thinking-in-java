package com.sangou;

public class Cartoon extends Drawing {
    Cartoon() {
        System.out.println("Cartoon constructed");
    }
}

class Art {
    Art() {
        System.out.println("Art constructed");
    }
}

class Drawing extends Art {
    Drawing() {
        System.out.println("Drawing constructed");
    }
}