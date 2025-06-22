package oop;

class Animal {
    void sound() {
        System.out.println("Animal makes sound");
    }
}

class Cat extends Animal {
    void sound() {
        System.out.println("Cat meows");
    }
}

class Cow extends Animal {
    void sound() {
        System.out.println("Cow moos");
    }
}

public class OOP6_Polymorphism {
    public static void main(String[] args) {
        Animal a1 = new Cat();
        Animal a2 = new Cow();

        a1.sound();
        a2.sound();
    }
}
