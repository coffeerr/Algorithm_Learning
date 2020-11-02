package BookLearning.JavaConcurrent.Chapter_1;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/2 6:10 下午
 */

public class InterruptedTest2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {

                }
            }
        });
      //  Thread.currentThread().interrupt();
        thread1.start();
        thread1.interrupt();
        System.out.println("当前线程是否被中断：" + Thread.currentThread().isInterrupted());
        System.out.println("当前线程是否被中断：" + Thread.currentThread().isInterrupted());
        System.out.println("当前线程是否被中断：" + thread1.isInterrupted());
        System.out.println("当前线程是否被中断：" + thread1.interrupted());
    }


}
