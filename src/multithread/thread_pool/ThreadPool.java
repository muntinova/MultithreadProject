package multithread.thread_pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {
    private BlockingQueue taskQueue;
    private List<ThreadPoolRunnable> runnableList = new ArrayList<>();
    private boolean isStopped=false;

    public ThreadPool(int noOfThreads,int maxNoOfTasks){

        taskQueue=new ArrayBlockingQueue(maxNoOfTasks);
        for(int i=0;i<noOfThreads;i++){
            ThreadPoolRunnable poolRunnable=new ThreadPoolRunnable(taskQueue);

            runnableList.add(poolRunnable);
        }

        for(ThreadPoolRunnable runnable:runnableList){
            new Thread(runnable)
                    .start();
        }
    }

    public synchronized void execute(Runnable task){
        if(this.isStopped) throw new IllegalStateException("Thread pool is stopped");

        this.taskQueue.offer(task);

    }

    public synchronized void stop(){
        this.isStopped=true;
        for(ThreadPoolRunnable runnable:runnableList){
            runnable.doStop();
        }
    }

    public synchronized void waitUntilAllTasksFinished(){
        while(this.taskQueue.size()>0){
            try{
                Thread.sleep(1);
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }

    }

}
