package c11;

import java.lang.reflect.InvocationTargetException;

interface HasBatteries {
}

interface Waterproof {
}

interface ShootsThings {
}

class Toy {
    public Toy() {
    }

    public Toy(int i) {
    }
}

class FancyToy extends Toy implements HasBatteries, Waterproof, ShootsThings {
    public FancyToy() {
        super(1);
    }
}

public class ToyTest {
    public static void main(String[] args) {
        Class c = null;
        try {
            c = Class.forName("c11.FancyToy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        printInfo(c);
        Class[] interfaces = c.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            printInfo(interfaces[i]);
        }
        Class cy = c.getSuperclass();
        Object o = null;
        try {
            o = cy.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        printInfo(cy);
    }

    static void printInfo(Class cc) {
        System.out.println(
                "Class name: " + cc.getName() +
                        " is interface? [" +
                        cc.isInterface() + "]");
    }
}
