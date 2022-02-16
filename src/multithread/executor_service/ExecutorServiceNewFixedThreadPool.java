package multithread.executor_service;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceNewFixedThreadPool {
    public static void main(String[] args) {
        ExecutorService singleExecutorService = Executors.newSingleThreadExecutor();
        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(1);
        fixedExecutorService.execute(newRunnable("Task1"));
        fixedExecutorService.execute(newRunnable("Task2"));
        fixedExecutorService.execute(newRunnable("Task3"));

        fixedExecutorService.shutdown();


    }

    private static Runnable newRunnable(String msg){
        return new Runnable() {
            @Override
            public void run() {
                String completeMsg= Thread.currentThread().getName() + " : " +msg;
                System.out.println(completeMsg);
            }
        };
    }
}
