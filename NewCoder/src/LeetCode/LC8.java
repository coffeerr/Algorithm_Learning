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
        char[] c = s.toCharArray();
        StringBuilder tem = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        int arr = 0;
        int count = 0;
        while (c[count] != ' ') {
            count++;
        }
        for (int i = count; i < c.length; i++) {
            if (c[i] < '0' || c[i] > 9) {
                if (c[i] == '-') {
                    arr = -1;
                } else if (c[i] == '+') {
                    arr = 1;
                } else {
                    return 0;
                }
            } else {
                list.add(c[i] - '0');
            }
        }
        if (list.size() == 0) return 0;
        int sum = 0;
        int carry = 10 * arr;
        for (int k = 0; k < list.size(); k++) {
            sum = sum * carry + list.get(k);
            if (sum > Integer.MAX_VALUE / 10) return Integer.MAX_VALUE;
            if (sum < Integer.MIN_VALUE / 10) return Integer.MIN_VALUE;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
