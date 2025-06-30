package thread;

class MyThread extends Thread {
    private String taskName;

    public MyThread(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        // This is where the magic happenes
        // Whatever you put here runs in a separate thread
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " - Step " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                // TODO: handle exception
                System.out.println(taskName + " was interrupted");
            }
        }
        System.out.println(taskName + " completed");
    }
}

public class ThreadExample {
    public static void main(String[] args) {
        // Create two threads
        MyThread t1 = new MyThread("Cook Bacon");
        MyThread t2 = new MyThread("Make Toast");

        // Start them (like hiring two cooks)
        t1.start();
        t2.start();

        System.out.println("Both threads started! Main thread continues...");

        // Main thread can do other work too
        for (int i = 0; i <= 3; i++) {
            System.out.println("Main thread - Step " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}
