package oop;

import java.lang.Math;

class Shape {
    public double x1;
    public String type;

    void area(double x1, String type) {
        if (type == "square") {
            System.out.println("The square area is: " + x1 * x1);
        } else {
            System.out.println("The circle area is: " + Math.PI * x1 * x1);
        }
    }
}

class Circle extends Shape {
    private int radius;

    public void setRadius(int newRadius) {
        this.radius = newRadius;
    }

    public int getRadius() {
        return radius;
    }
}

class Square extends Shape {
    private int length;

    public void setLength(int newLength) {
        this.length = newLength;
    }

    public int getLength() {
        return length;
    }
}

public class OOP7_Polymorphism {
    public static void main(String[] args) {
        Circle a1 = new Circle();
        a1.setRadius(10);
        a1.area(a1.getRadius(), "circle");

        Square a2 = new Square();
        a2.setLength(8);
        a2.area(a2.getLength(), "square");

    }
}
