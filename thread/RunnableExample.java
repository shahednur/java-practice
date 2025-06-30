package thread;

class MyTask implements Runnable {
    private String taskName;

    public MyTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) {
            System.out.println(taskName + " - Step " + i + " [Thread: " + Thread.currentThread().getName() + "]");

            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                // TODO: handle exception
                System.out.println(taskName + " was interrupted! ");
                return;
            }
        }
        System.out.println(taskName + " completed!");
    }
}

public class RunnableExample {
    public static void main(String[] args) {
        // Create tasks
        MyTask task1 = new MyTask("Download file");
        MyTask task2 = new MyTask("Process Data");
        MyTask task3 = new MyTask("Send Email");

        // Create threads and assign tasks
        Thread t1 = new Thread(task1, "Worker-1");
        Thread t2 = new Thread(task2, "Worker-2");
        Thread t3 = new Thread(task3, "Worker-3");

        System.out.println("Starting all tasks...");
        t1.start();
        t2.start();
        t3.start();

        // Wait for all threads to complete
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            // TODO: handle exception
            System.out.println("Main thread was interrupted!");
        }

        System.out.println("All tasks completed! Program ending.");
    }
}
