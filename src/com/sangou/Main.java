package com.sangou;

import java.security.PrivilegedAction;
import java.util.BitSet;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

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

        Shape[] shapes = new Shape[9];
        for (int i = 0; i < shapes.length; i++) {
            shapes[i] = Shapes.randonShape();
        }
        for (Shape s : shapes) {
            System.out.println(s.getClass());
            s.draw();
        }

        Controller controller = new Controller();
        controller.addEvent(new Event(10) {
            @Override
            public void action() {
                System.out.println("new event");
            }

            @Override
            public String description() {
                return null;
            }
        });
        controller.run();

        BitSet bs = new BitSet();
        System.out.println(bs.size());
        System.out.println((1L << 2));
    }
}
