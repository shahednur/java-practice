package thread;

class SafeBankAccount {
    private int balance = 1000;

    // Safe method - synchronized ensures only one thread at a time
    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            System.out.println(
                    Thread.currentThread().getName() + " is withdrawing $" + amount + " (Balance: $ " + balance + ")");

            // Simulate processing time
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO: handle exception
                return;
            }

            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " completed withdrawl. New balance: $" + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " - Insufficient funds! (Balance: $" + balance
                    + ", Requested: $" + amount + ")");
        }
    }

    public synchronized int getBalance() {
        return balance;
    }

    // Alternative synchronized block instead of synchronized method
    public void deposit(int amount) {
        synchronized (this) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposite complete. Balance: $" + balance);
        }
    }
}

class SafeCustomer implements Runnable {
    private SafeBankAccount account;
    private int withdrawAmount;
    private String action;

    public SafeCustomer(SafeBankAccount account, int withdrawAmount, String action) {
        this.account = account;
        this.withdrawAmount = withdrawAmount;
        this.action = action;
    }

    @Override
    public void run() {
        for (int i = 0; i < 2; i++) {
            if ("withdraw".equals(action)) {
                account.withdraw(withdrawAmount);
            } else {
                account.deposit(withdrawAmount);
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                // TODO: handle exception
                return;
            }
        }
    }
}

public class SynchronizedSolution {
    public static void main(String[] args) throws InterruptedException {
        SafeBankAccount account = new SafeBankAccount();

        System.out.println("=== SAFE BANK ACCOUNT DEMO ===");
        System.out.println("Initial balance: $" + account.getBalance());

        // Create customers
        Thread customer1 = new Thread(new SafeCustomer(account, 200, "withdraw"));
        Thread customer2 = new Thread(new SafeCustomer(account, 300, "withdraw"));
        Thread customer3 = new Thread(new SafeCustomer(account, 150, "deposit"));

        // Start all threads
        customer1.start();
        customer2.start();
        customer3.start();

        // Wait for all to complete
        customer1.join();
        customer2.join();
        customer3.join();

        System.out.println("Final balance: $" + account.getBalance());
        System.out.println("Perfect! No race conditions!");
    }
}
