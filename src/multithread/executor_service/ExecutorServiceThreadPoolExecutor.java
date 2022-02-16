package multithread.executor_service;

import java.util.concurrent.*;

public class ExecutorServiceThreadPoolExecutor {
    public static void main(String[] args) {
        int corePoolSize=10;
        int maxPoolSize=20;
        long keepAliveTime=3000;

        ExecutorService threadPoolExecutor=
                new ThreadPoolExecutor(corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<>(128));

        threadPoolExecutor= Executors.newFixedThreadPool(3); //factory method

        ExecutorService scheduleExecutorService =
                new ScheduledThreadPoolExecutor(corePoolSize);

        scheduleExecutorService=Executors.newScheduledThreadPool(10);
    }



}
