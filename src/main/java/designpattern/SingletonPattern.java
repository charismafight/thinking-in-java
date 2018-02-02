package designpattern;

final class Singleton {
    private static Singleton s = new Singleton(47);
    private int i;

    private Singleton(int i) {
        this.i = i;
    }

    public static Singleton getHandle() {
        return s;
    }

    public int getValue() {
        return i;
    }

    public void setValue(int value) {
        i = value;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getHandle();
        System.out.println(singleton.getValue());
        Singleton singleton1 = singleton.getHandle();
        singleton1.setValue(9);
        System.out.println(singleton.getValue());
    }
}
