package multithread.executor_service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureService {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(1);
        //todo: submit method work similarly like execute method
        //      but submit method returns future which gives info about status of this task
        Future future = executorService.submit(newRunnable("Task 1"));
        //todo: this method can tell you whether the task has been executed  or not
        System.out.println(future.isDone());
        //todo: future.get method return a result from this task
        try{
            future.get();
        } catch (Exception e ){
            e.printStackTrace();
        }
        System.out.println(future.isDone());

        executorService.shutdown();
    }
    //however Runnable interface us unable to return any response because run method return void
    //so whatever what return will be null
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
