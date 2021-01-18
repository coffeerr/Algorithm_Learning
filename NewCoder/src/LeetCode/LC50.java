package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/9 8:49 上午
 */

public class LC50 {
    public double recursion(long N, double x) {
        if (N == 0) return 1.0;
        double y = recursion(N / 2, x);
        return N % 2 == 0 ? y * y : y * y * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? recursion(N, x) : recursion(-N, x);
    }
}
