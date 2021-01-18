package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @description: 最长上升子序列
 * @author: Desmand
 * @time: 2020/10/22 5:02 下午
 */

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}
