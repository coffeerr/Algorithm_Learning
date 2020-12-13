package Interview.Collection.DesignModel;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/13 12:00 下午
 */

public class LazySingle {
    private static LazySingle lazySingle = null;

    private LazySingle() {
    }

    public static LazySingle getInstance() {
        if (null == lazySingle) {
            lazySingle = new LazySingle();

        }
        return lazySingle;
    }
}
