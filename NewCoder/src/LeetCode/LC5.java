package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/5 12:09 下午
 */

public class LC5 {
    public String longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        int max = 0;
        int start = -1;
        int end = -1;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= 0; j--) {
                if (isT(i, j, str)) {
                    if ((j - i + 1) > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                }
            }
        }
        if (start != -1 && end != -1) return s.substring(start, end + 1);
        else return "";
    }

    public boolean isT(int i, int j, char[] s) {
        while (i < j) {
            if (s[i++] != s[j--]) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        char str[] = s.toCharArray();
        boolean dp[][] = new boolean[str.length][str.length];
        dp[0][0] = true;
        for (int i = 1; i < str.length; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (str[i] == str[j] && (i - j <= 2 || dp[j+1][i - 1])) {
                    dp[j][i] = true;
                } else dp[j][i] = false;
            }
        }
        int max = 1;
        int start = 0;
        int end = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = str.length - 1; j >= i; j--) {
                if (dp[i][j]) {
                    if ((j - i + 1) > max) {
                        start = i;
                        end = j;
                        max = j - i + 1;
                        break;
                    }
                }

            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        System.out.println(new LC5().longestPalindrome2("aacabdkacaa"));
    }
}
