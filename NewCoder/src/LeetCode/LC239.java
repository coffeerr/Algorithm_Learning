package LeetCode;

import java.util.LinkedList;

/**
 * @description: 滑动窗口最大值
 * @author: Desmand
 * @time: 2021/1/2 12:02 下午
 */

public class LC239 {
    //暴力
    public int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if(deque.peek()<=i-k){
                deque.poll();
            }
            if(i>=k-1){
                result[i-k+1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] ans = new LC239().maxSlidingWindow(nums, 3);
        for (int i : ans) {
            System.out.println(i);
        }
    }

}
