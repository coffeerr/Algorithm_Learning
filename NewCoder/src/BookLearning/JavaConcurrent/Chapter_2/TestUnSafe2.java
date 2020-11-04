package BookLearning.JavaConcurrent.Chapter_2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/3 4:45 下午
 */

public class TestUnSafe2 {
    static final Unsafe unsafe;
    static final long stateOffset;
    //static final long state2Offset;
    private volatile long state2 = 0;
    private volatile long state = 0;


    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
            //state2Offset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state2"));

        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafe2 test = new TestUnSafe2();
        System.out.println("PRE state: "+test.state);
       // System.out.println("PRE state2: "+test.state2);
        Boolean success = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
       // Boolean success2 = unsafe.compareAndSwapInt(test, state2Offset, 0, 2);
        System.out.println(success);
       // System.out.println(success2);
        System.out.println("AFTER state: "+test.state);
       // System.out.println("AFTER state2: "+test.state2);

    }
}
