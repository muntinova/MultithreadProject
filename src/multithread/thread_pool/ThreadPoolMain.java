package multithread.thread_pool;

public class ThreadPoolMain {
    public static void main(String[] args) throws Exception {
        //todo: ThreadPool with 3 thread max capacity 10 tasks  internally
        ThreadPool threadPool=new ThreadPool(3,10);
        //todo: then we loop 10 times
        for(int i=0;i<10;i++){
            int taskNo=i;
            threadPool.execute( ()->{
                String message = Thread.currentThread().getName()+
                        " : task " + taskNo;
                System.out.println(message);
            } );
        }
        //todo: waits until all the tasks are finished
        threadPool.waitUntilAllTasksFinished();
        //todo: then stopped
        threadPool.stop();
    }
}
