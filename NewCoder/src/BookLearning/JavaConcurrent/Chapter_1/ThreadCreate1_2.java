package BookLearning.JavaConcurrent.Chapter_1;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description: Thread的三种创建方式
 * @author: Desmand
 * @time: 2020/11/2 11:13 上午
 */

public class ThreadCreate1_2 {
    public static class ThreadDemo1 extends Thread {
        @Override
        public void run() {
            System.out.println("这是创建Thread的第一种方法");
        }
    }

    public static class ThreadDemo2 implements Runnable {
        @Override
        public void run() {
            System.out.println("这是创建Thread的第二种方法");
        }
    }

    public static class ThreadDemo3 implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(">>>" + "任务启动");
            Date dateTmp1 = new Date();
            Thread.sleep(1000);
            Date dateTmp2 = new Date();
            long time = dateTmp2.getTime() - dateTmp1.getTime();
            System.out.println(">>>" + "任务终止");
            return "任务返回运行结果,当前任务时间【" + time + "毫秒】";
//            return "这是创建Thread的第三种方法";
        }
    }

    public static void main(String[] args) {
        ThreadDemo1 demo1 = new ThreadDemo1();
        //demo1.start();

        ThreadDemo2 demo2 = new ThreadDemo2();
        //demo2.run();
        //new Thread(demo2).start();

        FutureTask<String> futureTask = new FutureTask<>(new ThreadDemo3());
        new Thread(futureTask).start();
        demo1.start();
        new Thread(demo2).start();
        try {
            String result = futureTask.get();
            System.out.println("result: " + result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
