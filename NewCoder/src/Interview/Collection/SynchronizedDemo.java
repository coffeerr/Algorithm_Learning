package Interview.Collection;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/19 9:27 下午
 */
public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }
    }
}

