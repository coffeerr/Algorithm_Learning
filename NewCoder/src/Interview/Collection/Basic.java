package Interview.Collection;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/18 12:10 下午
 */

public class Basic {
    //    public static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
//   // static ThreadLocal threadLocal = new ThreadLocal();
//    public static void main(String[] args) {
//
//        inheritableThreadLocal.set("父线程放入");
//        System.out.println("父线程"+Thread.currentThread().getName());
//        new Thread(() -> {
//            System.out.println("子线程"+Thread.currentThread().getName());
//            System.out.println("子线程获取到的值：" + inheritableThreadLocal.get());
//        }).start();
//
//    }
//    -----
//    static ThreadLocal threadLocal = new ThreadLocal();
//
//    public static void main(String[] args) {
//        threadLocal.set("father's");
//        System.out.println("父线程"+Thread.currentThread().getName());
//        new Thread(()->{
//            System.out.println("子线程"+Thread.currentThread().getName());
//            System.out.println("子线程获取到的值：" + threadLocal.get());
//        }).start();
//    }
//
//    @Override
//    public void run() {
//
//    }
    public static void main(String[] args) {
        //ThreadPoolExecutor te = new ThreadPoolExecutor();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
    }

}
