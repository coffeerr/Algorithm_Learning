package BookLearning.JavaConcurrent.Chapter_1;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/2 5:54 下午
 */

public class InterruptTest1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("child thread is sleeping");
                    Thread.sleep(2);
                    System.out.println("child thread is awaking");
                } catch (InterruptedException e) {
                    System.out.println("child is interrupted while sleeping");
                    return;
                }
                System.out.println("child thread run normally");
            }
        });
        thread1.start();
        thread1.isInterrupted();
        try {
            Thread.sleep(3);
            System.out.println("Main thread is interrupting the child thread");
            thread1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
