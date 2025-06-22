package oop;

class Phone {
    String number;
    String CityCode;

    void dial() {
        System.out.println("Last dialed number is: " + number + ", and city is: " + CityCode);
    }
}

class Book {
    String name;
    int marks;

    void result() {
        System.out.println("Result: " + name + ", Marks " + marks);
    }
}

class Student {
    String name;
    String ClassName;

    void profile() {
        System.out.println("Student Profile: " + name + ", Class " + ClassName);
    }
}

public class OOP2_ClassObject {
    public static void main(String[] args) {
        // Student Profile
        Student student = new Student();
        student.name = "AN Rolex";
        student.ClassName = "Six";
        student.profile();

        // Student Result
        Book book = new Book();
        book.name = "Bangla";
        book.marks = 90;
        book.result();

        // Student Call history
        Phone phone = new Phone();
        phone.number = "01923065492";
        phone.CityCode = "80";
        phone.dial();
    }
}