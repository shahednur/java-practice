package thread;

public class Synchronization {
    private int count = 0;

    // Unsafe - race condition
    public void incrementUnsafe() {
        count++;
    }

    // Safe - Synchronized method
    public synchronized void increment() {
        count++;
    }

    // Safe - Synchronized block
    public void incrementWithBlock() {
        synchronized (this) {
            count++;
        }
    }

    public synchronized int getCount() {
        return count;
    }
}
