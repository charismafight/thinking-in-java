package com.sangou;

import org.jetbrains.annotations.Nullable;

class Shape {
    void draw() {
    }


    void erase() {
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Circle draw");
    }

    @Override
    void erase() {
        System.out.println("Circle erase");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Square draw");
    }

    @Override
    void erase() {
        System.out.println("Square erase");
    }
}

class Triangle extends Shape {
    @Override
    void draw() {
        System.out.println("Triangle draw");
    }

    @Override
    void erase() {
        System.out.println("Triangle erase");
    }
}

public class Shapes extends Shape {
    @Nullable
    public static Shape randonShape() {
        switch ((int) (Math.random() * 3)) {
            case 0: {
                return new Circle();
            }
            case 1: {
                return new Square();
            }
            case 2: {
                return new Triangle();
            }
            default:
                return null;
        }
    }
}