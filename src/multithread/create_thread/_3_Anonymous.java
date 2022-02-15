package multithread.create_thread;

public class _3_Anonymous {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("My Thread is running");
                System.out.println("My Thread is finished");
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
