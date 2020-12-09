package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/8 9:27 上午
 */

public class LC153 {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        if (l == r) return nums[0];
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
