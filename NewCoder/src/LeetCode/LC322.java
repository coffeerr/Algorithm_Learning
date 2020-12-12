package LeetCode;

import java.util.Arrays;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/12 2:46 下午
 */

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 2];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }
        return dp[amount];
    }
}
