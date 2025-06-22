package oop;

class User {
    private String name;
    private int age;

    public void setName(String NewName) {
        this.name = NewName;
    }

    public String getName() {
        return name;
    }

    public void setAge(int NewAge) {
        this.age = NewAge;
    }

    public int getAge() {
        return age;
    }
}

public class OOP4_Encapsulation {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Shahed");
        user.setAge(34);
        System.out.println("My name is: " + user.getName() + " and my age is: " + user.getAge());
    }
}
