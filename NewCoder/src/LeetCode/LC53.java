package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/7 7:20 下午
 */

public class LC53 {
    public int maxSubArray(int[] nums) {
        //
        if (nums.length == 0 && nums == null) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1] + dp[i]);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
