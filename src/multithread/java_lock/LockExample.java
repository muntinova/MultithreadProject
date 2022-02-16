package multithread.java_lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(); //use ReentrantLock instance as lock
        lock.lock();

        //do something

        lock.unlock();


    }
}
