package multithread.executor_service;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCallableService {
    public static void main(String[] args) {
        ExecutorService executorService =
                Executors.newFixedThreadPool(1);

        Future future = executorService.submit(newCallable("Task 1"));

        System.out.println(future.isDone());

        try{
           String result =(String) future.get();
            System.out.println(result);
        } catch (Exception e ){
            e.printStackTrace();
        }
        System.out.println(future.isDone());

        executorService.shutdown();
    }

    private static Callable newCallable(String msg){
        return new Callable() {
            @Override
            public Object call() throws Exception {
                return Thread.currentThread().getName() + " : " + msg;
            }
        };

    }
}
