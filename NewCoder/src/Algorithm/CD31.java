package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;

/**
 * @description: 最长公共子序列
 * @author: Desmand
 * @time: 2020/11/13 8:03 下午
 */

public class CD31 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    private static int[][] getCommonStr(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int dp[][] = new int[len1][len2];
        //初始化
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 1 : 0;
        for (int i = 1; i < len1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], s1.charAt(i) == s2.charAt(0) ? 1 : 0);
        }
        for (int j = 1; j < len2; j++) {
            dp[0][j] = Math.max(dp[0][j - 1], s1.charAt(0) == s2.charAt(j) ? 1 : 0);
        }
        //填充
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

    public static char[] getAns(String s1, String s2) {
        if (s1.equals("") || s2.equals("") || s1.length() == 0 || s2.length() == 0) return null;
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = getCommonStr(s1, s2);
        char[] res = new char[dp[len1 - 1][len2 - 1]];
        int index = dp[len1 - 1][len2 - 1] - 1;
        int n = len1 - 1;
        int m = len2 - 1;
        while (index >= 0) {
            if (n > 0 && dp[n][m] == dp[n - 1][m]) {
                n--;
            } else if (m > 0 && dp[n][m] == dp[n][m - 1]) {
                m--;
            } else {
                res[index--] = s1.charAt(n);
                n--;
                m--;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(getAns(s1, s2));
    }
}
