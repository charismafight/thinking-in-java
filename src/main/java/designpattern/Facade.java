package designpattern;

import java.util.ArrayList;
import java.util.List;

public class Facade {
    // ******

}

class Switch {
    private List<Elector> list;

    public Switch() {
        list = new ArrayList<>();
        list.add(new Light());
        list.add(new TV());
        list.add(new EFan());
    }

    public void use(int index) {
        list.get(index).on();
        // or
        list.get(index).off();
    }
}

interface Elector {
    void on();

    void off();
}


class Light implements Elector {

    @Override
    public void on() {
        System.out.println("Light on");
    }

    @Override
    public void off() {
        System.out.println("Light off");
    }
}

class TV implements Elector {
    @Override
    public void on() {
        System.out.println("TV on");
    }

    @Override
    public void off() {
        System.out.println("TV off");
    }
}

class EFan implements Elector {
    @Override
    public void on() {
        System.out.println("EFan on");
    }

    @Override
    public void off() {
        System.out.println("EFan off");
    }
}