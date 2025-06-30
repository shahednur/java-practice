package thread;

public class Pattern01 extends Thread {
    private String name;

    public Pattern01(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " - Count: " + i);
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    public static void main(String[] args) {
        Pattern01 t1 = new Pattern01("Shahed");
        t1.start();
    }
}
