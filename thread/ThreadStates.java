package thread;

public class ThreadStates {
    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            try {
                System.out.println("Worker: I'm starting my work!");

                // TIMED_WAITING state
                Thread.sleep(2000);
                System.out.println("Worker: I finished sleeping!");

                // Some work
                for (int i = 0; i <= 3; i++) {
                    System.out.println("Worker: Working step: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                // TODO: handle exception
                System.out.println("Worker: I was interrupted!");
            }
        }, "WorkerThread");

        // New Stae
        System.out.println("Thread state: " + worker.getState());

        // Start the thread
        worker.start();
        System.out.println("Thread state after start(): " + worker.getState());

        // Let it run for a bit
        Thread.sleep(500);
        System.out.println("Thread state while running: " + worker.getState());

        // Check while it's sleeping
        Thread.sleep(1000);
        System.out.println("Thread state while sleeping: " + worker.getState());

        // Wait for it to complete
        worker.join();
        System.out.println("Thread state after completion: " + worker.getState());

        System.out.println("Main thread: All done!");
    }
}
