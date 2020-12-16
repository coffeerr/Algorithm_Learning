package LeetCode;

/**
 * @description: 买卖股票的最佳时机2
 * @author: Desmand
 * @time: 2020/12/16 10:05 上午
 */

public class LC122 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int dp[][] = new int[len][2];

        //base case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
        }
        return dp[len - 1][0];
    }
}
