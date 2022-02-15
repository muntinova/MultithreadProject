package multithread.memory_model;

//todo: 2 different runnable object 2 threads they have 2 thread stack which stored all instance variables.
class MyRunnable2 implements Runnable {
    private int count=0;
    @Override
    public void run() {
        for (int i=0;i<1_000;i++){
            count++;
        }
        System.out.println(Thread.currentThread().getName() + " : "+ this.count);
    }
}

public class _2_Runnable_2_Thread_SeperateObjects {
    public static void main(String[] args) {
        int myLocalVar=0;
        String myLocalString="Text";

        Runnable runnable1= new MyRunnable2();

        Runnable runnable2= new MyRunnable2();


        Thread thread1=new Thread(runnable1);
        Thread thread2=new Thread(runnable2);

        thread1.start();
        thread2.start();

     //todo: answers Thread-1 : 1000  Thread-0 : 1000

    }
}
