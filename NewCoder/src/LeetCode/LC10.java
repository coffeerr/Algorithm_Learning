package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/22 5:02 下午
 */

public class LC10 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (p.charAt(j - 1) == '*') {
                    //匹配0次
                    dp[i][j] = dp[i][j - 2];
                    if (match(s, p, i, j-1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static boolean match(String s, String p, int i, int j) {
        if (i == 0) return false;
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
