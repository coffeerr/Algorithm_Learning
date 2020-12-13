package Interview.Collection.DesignModel;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/13 11:58 上午
 */

public class Single {
    //饿汉
    private static Single singleInstance = new Single();

    private Single() {
    }

    public static Single getInstance() {
        return singleInstance;
    }
}
