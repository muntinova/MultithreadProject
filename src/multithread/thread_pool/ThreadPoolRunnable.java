package multithread.thread_pool;


import java.util.concurrent.BlockingQueue;

public class ThreadPoolRunnable implements Runnable{
    private Thread thread;
    private BlockingQueue taskQueue;
    private boolean isStopped=false;


    public ThreadPoolRunnable(BlockingQueue taskQueue) {
        this.taskQueue = taskQueue;
    }


    @Override
    public void run() {
        this.thread=Thread.currentThread();

        while (!isStopped){
                try {
                    Runnable runnable = (Runnable) taskQueue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }

    public synchronized void doStop(){
        isStopped=true;
        this.thread.interrupt();

    }

    public synchronized boolean isStopped(){
        return isStopped;
    }

}
