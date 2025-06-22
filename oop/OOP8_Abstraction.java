package oop;

abstract class Animal {
    abstract void makeSound();

    void breathe() {
        System.out.println("Animal breathes");
    }
}

class Lion extends Animal {
    void makeSound() {
        System.out.println("Roar");
    }
}

class Cow extends Animal {
    void makeSound() {
        System.out.println("Moo");
    }
}

public class OOP8_Abstraction {
    public static void main(String[] args) {
        Lion lion = new Lion();
        lion.makeSound();
        lion.breathe();
    }
}
