package Interview.MultiThreading;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/14 12:20 下午
 */

public class Case1 {
    // 启动两个线程, 一个输出 1,3,5,7…99, 另一个输出 2,4,6,8…100 最后 STDOUT 中按序输出 1,2,3,4,5…100
    public static final Object flag = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (flag) {
                    for (int i = 1; i <= 100; i+=2) {
                        flag.notify();
                        System.out.println(i);
                        try {
                            flag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (flag) {
                    for (int i = 0; i <= 100; i+=2) {
                        flag.notify();
                        System.out.println(i);
                        try {
                            flag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread2.start();
        thread1.start();
    }
}
