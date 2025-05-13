package multic;

import java.util.concurrent.locks.ReentrantLock;

public class TreadPrint extends Thread{

    private static int count = 0;
    private static final Object lock = new Object();
    private static final ReentrantLock reentrantLock = new ReentrantLock();

//    public void run() {
////        synchronized (TreadPrint.class) {
//        synchronized (lock) {
//            ++count;
//            System.out.println(count);
//        }
//    }

    public void run() {
        reentrantLock.lock();
//        try {
            ++count;
            System.out.println(count);
//        }
//        finally {
            reentrantLock.unlock();
//        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++) {
            new TreadPrint().start();
        }
    }
}
