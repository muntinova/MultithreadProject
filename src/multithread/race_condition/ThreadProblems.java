package multithread.race_condition;

public class ThreadProblems {
    public static void main(String[] args) {
        //first case
        //each iterating through loop 1000 times
        //result: we get 1000 each thread

        Runnable runnable1 = new MyRunnable();
        Runnable runnable2 = new MyRunnable();

        Thread thread1 = new Thread(runnable1,"Thread 1");
        Thread thread2 = new Thread(runnable2,"Thread 2");

        thread1.start();
        thread2.start();


        //second case
        //1 runnable and 2 threads are executing this loop same time and
        //they incrementing this same variable

        //result: we got different result
        // because threads are reading the value of count variable
        // and updating them and then writing them back so instead of
        //precise count they overwrite each other's.
        // Accounts they can't see that the one is currently one thread  is
        //currently in the process of updating the value.

        Runnable runnable3 = new MyRunnable();


        Thread thread3 = new Thread(runnable3,"Thread 3");
        Thread thread4 = new Thread(runnable3,"Thread 4");

        thread3.start();
        thread4.start();

        // That's why count will be imprecise if we want to fix that
        //simply by wrapping synchronized block
        //result: when counting is done exactly precisely synchronized
        //then we would expect the result
        Runnable runnable5 = new MySynchRunnable();


        Thread thread5 = new Thread(runnable5,"Thread 5");
        Thread thread6 = new Thread(runnable5,"Thread 6");
        //thread5 doesn't get so high account but its ok,
        //thread6 to finished 1000 iteration the result
        thread5.start();
        thread6.start();
    }
}
