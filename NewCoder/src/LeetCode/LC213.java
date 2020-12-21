package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/21 9:58 上午
 */

public class LC213 {
    public int rob(int[] nums) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(getAns(nums, 0, nums.length - 2),
                getAns(nums, 1, nums.length - 1));
    }

    int getAns(int[] nums, int start, int end) {
        int dp_i = 0, dp_1 = 0, dp_2 = 0;
        for (int i = end; i >= start; i--) {
            dp_i = Math.max(dp_1, nums[i] + dp_2);
            dp_2 = dp_1;
            dp_1 = dp_i;
        }
        return dp_i;
    }
}
