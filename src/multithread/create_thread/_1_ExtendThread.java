package multithread.create_thread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("My Thread is running");
        System.out.println("My Thread is finished");
    }
}

class ThreadExampleExtendThread {

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start(); //execute run method

    }
}
