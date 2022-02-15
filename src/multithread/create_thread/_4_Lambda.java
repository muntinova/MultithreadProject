package multithread.create_thread;

public class _4_Lambda {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("My Thread is running");
            System.out.println("My Thread is finished");
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
