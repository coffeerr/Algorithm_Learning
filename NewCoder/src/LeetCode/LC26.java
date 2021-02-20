package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/2/16 11:04 上午
 */

public class LC26 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int i = 0;
        for (int j = 1; j < len; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;


    }
}
