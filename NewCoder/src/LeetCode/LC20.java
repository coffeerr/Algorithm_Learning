package LeetCode;

import java.util.Stack;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/3 12:59 下午
 */

public class LC20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int count = 0;
        char temp = '0';
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                count++;
                stack.push(chars[i]);
            }
            if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
                count--;
                if (!stack.isEmpty()) {
                    temp = stack.pop();
                }
                if (temp == '(' && chars[i] == ')' || temp == '[' && chars[i] == ']' || temp == '{' && chars[i] == '}') {
                } else {
                    return false;
                }
            }
        }

        if (stack.isEmpty() && count == 0) {
            return true;
        }
        return false;
    }
}
