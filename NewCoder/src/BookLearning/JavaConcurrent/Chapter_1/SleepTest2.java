package BookLearning.JavaConcurrent.Chapter_1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/2 5:29 下午
 */

public class SleepTest2 {
    //  创建独占锁
    public static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("child Thread1 is in sleep");
                    Thread.sleep(2000);
                    System.out.println("child Thread1 is in awaked");
                    //lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("child thread2 is in sleep");
                    Thread.sleep(2000);
                    System.out.println("child thread2 is in awaked");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
