package LeetCode;

import java.util.Arrays;

/**
 * @description: 最长上升子序列
 * @author: Desmand
 * @time: 2020/10/22 5:02 下午
 */

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    //dp[i]记录了i位置之前的最长升序元素个数
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
