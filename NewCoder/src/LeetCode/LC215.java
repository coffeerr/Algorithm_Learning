package LeetCode;

import java.util.Arrays;
import java.util.Random;

/**
 * @description: top K
 * @author: Desmand
 * @time: 2020/11/24 4:14 下午
 */

public class LC215 {
    //    public static int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length-k];
//    }
    private static Random random = new Random(System.currentTimeMillis());

    public static int findKthLargest(int[] arr, int k) {
        int length = arr.length;
        int target = length - k;
        int l = 0;
        int r = length - 1;
        while (true) {
            int ans = partition(arr, l, r);
            if (ans == target) {
                return arr[ans];
            } else if (ans > target) {
                r = ans - 1;
            } else {
                l = ans + 1;
            }
        }
    }

    public static int partition(int[] arr, int l, int r) {
        int rand = l + 1 + random.nextInt(r - l);
        swap(arr,l,rand);
        int pivot = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println(findKthLargest(arr, k));
        //System.out.println(quickSelect(arr,k));
    }
}
