package oop;

class Animal {
    void sound() {
        System.out.println("Animal makes sounds");
    }
}

class Dog extends Animal {
    private String DogSound;

    public void setDogSound(String newDogSound) {
        this.DogSound = newDogSound;
    }

    public String getDogSound() {
        return DogSound;
    }
}

class Cat extends Animal {
    private String CatSound;

    public void setCatSound(String newCatSound) {
        this.CatSound = newCatSound;
    }

    public String getCatSound() {
        return CatSound;
    }
}

class Cow extends Animal {
    private String CowSound;

    public void setCowSound(String newCowSound) {
        this.CowSound = newCowSound;
    }

    public String getCowSound() {
        return CowSound;
    }
}

class Horse extends Animal {
    private String HorseSound;

    public void setHorseSound(String newHorseSound) {
        this.HorseSound = newHorseSound;
    }

    public String getHorseSound() {
        return HorseSound;
    }
}

public class OOP5_Inheritance {
    public static void main(String[] args) {

        // Dog
        Dog dog = new Dog();
        dog.setDogSound("Barks");
        System.out.println("Dog: " + dog.getDogSound());

        // Cat
        Cat cat = new Cat();
        cat.setCatSound("Meow");
        System.out.println("Cat: " + cat.getCatSound());

        // Cow
        Cow cow = new Cow();
        cow.setCowSound("Moo");
        System.out.println("Cow: " + cow.getCowSound());

        // Horse
        Horse horse = new Horse();
        horse.setHorseSound("heigh");
        System.out.println("Horse: " + horse.getHorseSound());
    }
}
