package BookLearning.JavaConcurrent.Chapter_1;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/2 8:31 下午
 */

public class ThreadLocalTest1 {
    public static void main(String[] args) {
        ThreadLocal<String> localVariable = new ThreadLocal<>();
        InheritableThreadLocal<String> shareVariable = new InheritableThreadLocal<>();
        localVariable.set("本地变量");
        shareVariable.set("共享变量");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //localVariable.set("本地变量2");
               // shareVariable.set("共享变量-来自子线程");
                System.out.println("child thread:"+localVariable.get());
                //System.out.println("child share thread:"+shareVariable.get());
            }
        });
        thread.start();
        Thread thread2 = Thread.currentThread();
        System.out.println("main thread:"+localVariable.get());
        System.out.println("main share thread:"+shareVariable.get());
    }
}
