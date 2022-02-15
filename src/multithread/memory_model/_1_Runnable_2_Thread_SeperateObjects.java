package multithread.memory_model;

//todo: only one runnable object passed 2 threads they have 2 thread stack which stored all instance variables.

class MyRunnable implements Runnable {
    private int count=0;

    @Override
    public void run() {

        for (int i=0;i<1_000_000;i++){
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " : "+ this.count);
    }
}

public class _1_Runnable_2_Thread_SeperateObjects {
    public static void main(String[] args) {
        int myLocalVar=0;
        String myLocalString="Text";

        Runnable runnable1= new MyRunnable();

    //todo: 2 threads share the one runnable
        Thread thread1=new Thread(runnable1);
        Thread thread2=new Thread(runnable1);

        thread1.start();
        thread2.start();

     //todo: answers Thread-1 : 2000  Thread-0 : 1000

    }
}
