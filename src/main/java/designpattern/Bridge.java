package designpattern;

public class Bridge {
    public static void main(String[] args) {
        // use 2d circle
        Shape circle2d = new Circle();
        circle2d.setD(new D2());
        circle2d.run();

        // use 3d Triagnle
        Shape triangle3d = new Triangle();
        triangle3d.setD(new D3());
        triangle3d.run();

    }
}

abstract class Shape {
    public MyDimension getD() {
        return d;
    }

    public void setD(MyDimension d) {
        this.d = d;
    }

    private MyDimension d;

    public void run() {
        System.out.println(d);
    }
}


class Circle extends Shape {

}

class Triangle extends Shape {

}

abstract class MyDimension {
    @Override
    public String toString() {
        return this.getClass().toString();
    }
}

class D2 extends MyDimension {

}

class D3 extends MyDimension {

}