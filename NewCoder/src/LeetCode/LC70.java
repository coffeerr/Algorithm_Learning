package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/6 9:24 上午
 */

public class LC70 {
    public int climbStairs(int n) {
        int dp[] = new int[n + 2];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
