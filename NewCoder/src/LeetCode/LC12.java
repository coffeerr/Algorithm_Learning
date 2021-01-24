package LeetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/22 9:09 下午
 */

//罗马数字
public class LC12 {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] conv = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int index = 0;
        StringBuilder ans = new StringBuilder("");
        while (index < 13) {
            while (num >= nums[index]) {
                ans.append(conv[index]);
                num -= nums[index];
            }
            index++;
        }
        return ans.toString();
    }

    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int a = nextInt();
        System.out.println(new LC12().intToRoman(a));
    }
}
