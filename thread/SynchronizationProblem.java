package thread;

class BankAccount2 {
    private int balance = 10000;

    // UNSAFE method - multiple threads can interfere with each other
    public void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(Thread.currentThread().getName() + " is withdrawing $ " + amount);

            // Simulate some processing time
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                return;
            }

            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawal. Balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - Insufficient funds!");
        }
    }

    public int getBalance() {
        return balance;
    }
}

class Customer implements Runnable {
    private BankAccount2 account;
    private int withdrawAmount;

    public Customer(BankAccount2 account, int withdrawAmount) {
        this.account = account;
        this.withdrawAmount = withdrawAmount;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.withdraw(withdrawAmount);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO: handle exception
                return;
            }
        }
    }
}

public class SynchronizationProblem {
    public static void main(String[] args) throws InterruptedException {
        BankAccount2 sharedAccount = new BankAccount2();

        System.out.println("Initial balance: $" + sharedAccount.getBalance());

        // Two customers trying to withdraw from same account
        Thread customer1 = new Thread(new Customer(sharedAccount, 300), "Customer 1");
        Thread customer2 = new Thread(new Customer(sharedAccount, 200), "Customer 2");

        customer1.start();
        customer2.start();

        customer1.join();
        customer2.join();

        System.out.println("Final balance: $ " + sharedAccount.getBalance());
        System.out.println("Something is wrong! We might have negative balance!");
    }
}
