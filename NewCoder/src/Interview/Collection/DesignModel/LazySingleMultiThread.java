package Interview.Collection.DesignModel;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/13 12:02 下午
 */

public class LazySingleMultiThread {
    private static LazySingleMultiThread lazySingleMultiThread = null;

    private LazySingleMultiThread() {
    }

    public static LazySingleMultiThread getInstance() {
        if (null == lazySingleMultiThread) {
            synchronized (LazySingleMultiThread.class) {
                if (null == lazySingleMultiThread) {
                    lazySingleMultiThread = new LazySingleMultiThread();
                }
            }
        }
        return lazySingleMultiThread;
    }
}
