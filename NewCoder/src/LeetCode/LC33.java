package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/8 9:31 上午
 */

public class LC33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        int start, end;
        if (target > nums[0] && target <= nums[l - 1]) {
            start = 0;
            end = l - 1;

        } else if (target > nums[0] && target <= nums[nums.length - 1]) {
            start = l;
            end = nums.length - 1;
        } else {
            return -1;
        }
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            return start;
        } else {
            return -1;
        }
    }
}
