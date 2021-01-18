package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/8 9:18 上午
 */

public class LC189 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int[] arr = new int[len * 2];
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }
        for (int i = len; i < len * 2; i++) {
            arr[i] = nums[i - len];
        }
        int count = 0;
        for (int i = len - k; i < 2 * len - k; i++) {
            nums[count++] = arr[i];
        }
    }

    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        if(len==0)return;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {-1};
        int nums[] = {1,2,3,4,5,6,7};
        new LC189().rotate2(nums, 3);
        for (int i :
                nums) {
            System.out.println(i);

        }

    }
}
