package LeetCode;

import java.util.Arrays;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/8 8:52 上午
 */

public class LC88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int count = 0;
//        for (int i = m; i < nums1.length; i++) {
//            nums1[i] = nums2[count++];
//        }
//        Arrays.sort(nums1);
        int p1 = m - 1;
        int p2 = n - 1;
        int curp = nums1.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums2[p2] > nums1[p1]) {
                nums1[curp--] = nums2[p2--];
            } else {
                nums1[p1 + 1] = nums1[p1];
                nums1[p1--] = nums2[curp--];
            }
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}
