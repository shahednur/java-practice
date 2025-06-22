package oop;

interface Flyable {
    void fly();
}

class Bird implements Flyable {
    public void fly() {
        System.out.println("Bird is flying");
    }
}

public class OOP10_Interface {
    public static void main(String[] args) {
        Bird b = new Bird();
        b.fly();
    }
}
