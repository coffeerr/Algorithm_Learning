package BookLearning.JavaConcurrent.Chapter_2;

import sun.misc.Unsafe;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/3 4:45 下午
 */

public class TestUnSafe {
    static final Unsafe unsafe = Unsafe.getUnsafe();
    static final long stateOffset;
    private volatile long state = 0;

    static {
        try {
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafe test = new TestUnSafe();
        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }
}
