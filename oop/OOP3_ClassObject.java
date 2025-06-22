package oop;

class BankAccount {
    private int balance = 10000;

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount > 0)
            balance += amount;
    }
}

public class OOP3_ClassObject {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.deposit(1500);
        System.out.println("Balance: " + acc.getBalance());
    }
}
