package Interview.Collection;

import java.util.Random;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/4 6:47 下午
 */

public class ThreadRandomTest {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(100));
    }
}
