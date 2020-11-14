package Algorithm;

import java.util.Scanner;

/**
 * @description: 最长公共子串
 * @author: Desmand
 * @time: 2020/11/14 11:46 上午
 */

public class CD33 {
    public static String getCommonstr(String s1, String s2) {
        if (s1 == null && s2 == null) return "-1";
        if (s1 == null || s2 == null) return "-1";
        if (s1.length() == 0 || s2.length() == 0) return "-1";
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int len1 = str1.length - 1;
        int len2 = str2.length - 1;
        int[][] dp = getDp1(str1, str2);
        //find the target
        int end = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (dp[i][j] > max) {
                    end = i;
                    max = dp[i][j];
                }
            }
        }
        if (max == 0) return "-1";
        return s1.substring(end - max + 1, end + 1);
    }

    //初始dp
    public static int[][] getDp1(char[] s1, char[] s2) {
        int len1 = s1.length - 1;
        int len2 = s2.length - 1;
        int[][] dp = new int[len1 + 1][len2 + 1];
        //base case
        for (int i = 0; i <= len1; i++) {
            if (s1[i] == s2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j <= len2; j++) {
            if (s1[0] == s2[j]) {
                dp[0][j] = 1;
            }
        }
        //common case
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp;
    }

    //空间压缩
    public static int[][] getDp2(char[] s1, char[] s2) {
        int len1 = s1.length - 1;
        int len2 = s2.length - 1;
        int[][] dp = new int[len1 + 1][len2 + 1];
        //base case
        for (int i = 0; i <= len1; i++) {
            if (s1[i] == s2[0]) {
                dp[i][0] = 1;
            }
        }
        for (int j = 0; j <= len2; j++) {
            if (s1[0] == s2[j]) {
                dp[0][j] = 1;
            }
        }
        //common case
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.print(getCommonstr(s1, s2));
    }
}
