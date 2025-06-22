package oop;

interface Playable {
    void play();
}

class Guitar implements Playable {
    public void play() {
        System.out.println("Guilter is playing");
    }
}

class Piano implements Playable {
    public void play() {
        System.out.println("Piano is playing");
    }
}

public class OOP11_Interface {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        guitar.play();

        Piano piano = new Piano();
        piano.play();
    }
}
