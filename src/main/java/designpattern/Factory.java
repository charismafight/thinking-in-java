package designpattern;

public class Factory {
    public static Car mkCar(String para) {
        if (para.equals("bmw")) {
            return new BMWCar();
        } else if (para.equals("benz")) {
            return new BenzCar();
        } else {
            return null;
        }
    }
}


abstract class Car {
    public abstract void drive();
}

class BMWCar extends Car {

    @Override
    public void drive() {
        System.out.println("drive bmwcar");
    }
}

class BenzCar extends Car {

    @Override
    public void drive() {
        System.out.println("drive benz");
    }
}