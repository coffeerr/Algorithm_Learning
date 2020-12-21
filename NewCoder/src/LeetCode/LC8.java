package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/11 2:58 下午
 */

public class LC8 {
    public int myAtoi(String s) {
        int state = 0;//0 初始状态｜｜ 1--正整数｜｜2--负整数
        long ans = 0;
        char str[] = s.toCharArray();
        for (char c : str) {
            if (c == ' ' && state == 0) continue;
            else if (c == '+' && state == 0) {
                state = 1;
            } else if (c == '-' && state == 0) {
                state = 2;
            } else if (c >= '0' && c <= '9' && state == 0) {
                state = 1;
                ans = ans * 10 + (c - '0');
            } else if (c >= '0' && c <= '9') {
                ans = ans * 10 + (c - '0');
                if (ans > Integer.MAX_VALUE) break;
            } else break;
        }

        if (ans > Integer.MAX_VALUE) {
            if (state == 1) {
                ans = Integer.MAX_VALUE;
            } else if (state == 2) {
                ans = Integer.MIN_VALUE;
            }
        }
        if (state == 2) {
            ans = -ans;
        }
        return (int) ans;
    }

    public static void main(String[] args) {

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
