package oop;

class Car {
    String color;
    int speed;

    void drive() {
        System.out.println("Car is driving at " + speed + "km/h");
    }
}

public class OOP1_ClassObject {

    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.color = "Red";
        myCar.speed = 100;

        System.out.println("Color: " + myCar.color);
        myCar.drive();
    }
}
