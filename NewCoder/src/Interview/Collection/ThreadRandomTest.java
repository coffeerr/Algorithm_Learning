package Interview.Collection;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/4 6:47 下午
 */

public class ThreadRandomTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ThreadLocalRandom r = ThreadLocalRandom.current();
               // r.setSeed(10);
                System.out.println("子线程随机数："+r.nextInt(100));
            }
        });
        t1.start();
        ThreadLocalRandom r2 = ThreadLocalRandom.current();
        //r2.setSeed(10);
        System.out.println("父线程随机数："+r2.nextInt(100));
    }
}
