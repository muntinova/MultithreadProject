package multithread.create_thread;

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("My Thread is running");
        System.out.println("My Thread is finished");
    }
}

class ThreadExampleRunnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        thread.start();
    }
}
