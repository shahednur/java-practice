package oop;

abstract class Device {
    abstract void start();

    public String name;

    void run(String name) {
        System.out.println(name + " is running");
    }
}

class Mobile extends Device {
    void start() {
        System.out.println("Mobile device started");
    }
}

class Laptop extends Device {
    void start() {
        System.out.println("Laptop device started");
    }
}

class Watch extends Device {
    void start() {
        System.out.println("Watch device started");
    }
}

public class OOP9_Abstraction {
    public static void main(String[] args) {
        // Mobile
        Mobile mobile = new Mobile();
        mobile.start();
        mobile.run("Mobile");

        // Laptop
        Laptop laptop = new Laptop();
        laptop.start();
        laptop.run("Laptop");

        // Watch
        Watch watch = new Watch();
        watch.start();
        watch.run("Watch");
    }
}
