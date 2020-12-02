package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/1 12:48 下午
 */

public class LC69 {
    public int mySqrt(int x) {
        long l = 0;
        long r = x / 2 + 1;
        while (l < r) {
            long mid = (l + r + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int) l;
    }

    public static int test(int a) {
        return a >>> 1;
    }

    public static void main(String[] args) {
        System.out.println(test(10));
    }
}
