package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/10 4:34 下午
 */

public class LC42 {
    public int trap(int[] height) {
        if (height.length == 1) return 0;
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int k = i; k < height.length; k++) {
                max_right = Math.max(max_right, height[k]);
            }
            ans = ans + Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public int trapDp(int[] height) {
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(height[i - 1], max_left[i - 1]);
        }
        for (int j = height.length - 2; j >= 0; j--) {
            max_right[j] = Math.max(max_right[j + 1], height[j + 1]);

        }
        int ans = 0;
        for (int k = 1; k < height.length - 1; k++) {
            int min = Math.min(max_left[k], max_right[k]);
            if (min > height[k]) {
                ans = ans + min - height[k];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(-101%10);
        String s="";
        char c[] = s.toCharArray();
    }

}
