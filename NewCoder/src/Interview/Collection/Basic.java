package Interview.Collection;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/18 12:10 下午
 */

public class Basic {
    public static void main(String[] args) {
        //ThreadPoolExecutor te = new ThreadPoolExecutor();
        AtomicIntegerTest i = new AtomicIntegerTest();
        i.increment();
        int a = i.getCount();
        Condition condition;
        System.out.println(a);
    }
    static class AtomicIntegerTest {
        private AtomicInteger count = new AtomicInteger();
        //使用AtomicInteger之后，不需要对该方法加锁，也可以实现线程安全。
        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }
}
