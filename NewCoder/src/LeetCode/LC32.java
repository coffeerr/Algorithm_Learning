package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/3/1 12:10 下午
 */

public class LC32 {
    //最长子括号，可以使用方法：
    //1、动态规划（难以理解状态转换公式）
    //2、栈，使用栈来解决足以，需要注意的是，栈内保存的是当前左括号的位置，且初始化时，栈顶元素为-1，

    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        System.out.println( new LC32().longestValidParentheses("(())"));
    }
}
