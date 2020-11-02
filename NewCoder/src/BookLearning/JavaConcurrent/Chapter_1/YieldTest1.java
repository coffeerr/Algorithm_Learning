package BookLearning.JavaConcurrent.Chapter_1;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/2 5:39 下午
 */

public class YieldTest1 implements Runnable {
    public YieldTest1() {
        Thread thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if ((i % 5) == 0) {
                System.out.println(Thread.currentThread()+"yield cpu...");
                //Thread.yield();
            }
        }
        System.out.println(Thread.currentThread()+"is over");
    }

    public static void main(String[] args) {
        new YieldTest1();
        new YieldTest1();
        new YieldTest1();
    }
}
