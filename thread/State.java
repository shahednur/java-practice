package thread;

public class State {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    System.out.println("T1 State: " + Thread.currentThread().getState());
                    lock.wait();
                } catch (InterruptedException e) {
                    // TODO: handle exception
                    Thread.currentThread().interrupt();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO: handle exception
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Before start: " + t1.getState());
        t1.start();
        t2.start();

        Thread.sleep(100);
        System.out.println("T1 after start: " + t1.getState());
        System.out.println("T2 during sleep: " + t2.getState());

        synchronized (lock) {
            lock.notify();
        }

        t1.join();
        t2.join();

        System.out.println("T1 after completion: " + t1.getState());
    }
}
