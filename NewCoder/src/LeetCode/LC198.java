package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/21 9:36 上午
 */

public class LC198 {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 2];
        for (int i = nums.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[0];
    }

    public int rob2(int[] nums) {
        int dp_i = 0, dp_1 = 0, dp_2 = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            dp_i = Math.max(dp_1, nums[i] + dp_2);
            dp_2 = dp_1;
            dp_1 = dp_i;
        }
        return dp_i;

    }
}
