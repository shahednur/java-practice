package thread;

public class Pattern02 implements Runnable {
    private String taskName;

    public Pattern02(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName + " executed by " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Pattern02("Database Updated"));
        Thread t2 = new Thread(new Pattern02("Email has been sent"));

        t1.start();
        t2.start();
    }
}
