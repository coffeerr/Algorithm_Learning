package Interview.Collection;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/3 9:48 上午
 */

public class ThreadLocalTest {
    public static void main(String[] args) {

        ThreadLocal threadLocal = new InheritableThreadLocal();
        ThreadLocal threadLocal2 = new ThreadLocal();
        threadLocal.set("blue");
        threadLocal2.set("blue");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("child thread's variable is:"+threadLocal2.get());
                System.out.println("child thread's inheritedVariable is:"+threadLocal.get());
            }
        });
        thread.start();
    }
}
