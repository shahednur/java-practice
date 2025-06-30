package thread;

public class BankAccount {
    private double balance = 0;

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Balance: " + balance);
    }

    public synchronized boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdraw: " + amount + ", Balance: " + balance);
            return true;
        }
        return false;
    }

    public synchronized double getBalance() {
        return balance;
    }
}
