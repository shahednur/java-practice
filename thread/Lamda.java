package thread;

public class Lamda {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Lamda thread: " + Thread.currentThread().getName());
        });

        Thread t2 = new Thread(() -> {
            try {
                // Simulate work
                Thread.sleep(2000);
                System.out.println("Work completed");
            } catch (InterruptedException e) {
                // TODO: handle exception
                // Thread.currentThread.interrupt();
                System.out.println("Task interrupted");
            }
        });

        t1.start();
        t2.start();
    }
}
