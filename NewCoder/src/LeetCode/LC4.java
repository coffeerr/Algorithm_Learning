package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/21 8:46 下午
 */

public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums1.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || nums1[aStart] < nums2[bStart])) {
                right = nums1[aStart++];
            } else {
                right = nums2[bStart++];
            }
        }
        if (left % 2 == 0) {
            return (left + right) / 2.0;
        } else {
            return right;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {3,4};
        int[] nums2 = {};
        System.out.println(new LC4().findMedianSortedArrays(nums1, nums2));
    }
}
