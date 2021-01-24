package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/22 8:33 下午
 */
//盛最多水的容器
public class LC11 {
    //暴力
    public int maxArea1(int[] height) {
        int max = 0;
        if (height.length <= 1) {
            return 0;
        }
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return max;
    }

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1;
        int max = 0;
        while (i < j) {
            max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
            if (height[i] < height[j]) i++;
            else if (height[i] > height[j]) j--;
            else {
                break;
            }
        }
        return max;
    }
}
