package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/12 8:46 上午
 */

public class LC91 {
    public int numDecodings(String s) {
        char[] c = s.toCharArray();
        if (c[0] == '0') return 0;
        int dp[] = new int[c.length];
        dp[0] = 1;

        for (int i = 1; i < c.length; i++) {
            if (c[i] == '0') {
                if (c[i - 1] == '1' || c[i - 1] == '2') dp[i] = dp[i - 2];
                else return 0;
            } else if (c[i - 1] == '1') {
                if (i == 1) dp[1] = 2;
                dp[i] = dp[i - 1] + dp[i - 2];
            } else if (c[i - 1] == '2') {
                if (c[i] >= '1' && c[i] <= '6') {
                    if (i == 1) dp[1] = 2;
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[c.length - 1];
    }
}
