package LeetCode;

/**
 * @description: 猜数字游戏
 * @author: Desmand
 * @time: 2020/10/22 5:27 下午
 */

public class LC299 {
    public String getHint(String secret, String guess) {
        int a = getA(secret, guess);
        int b = getB(secret, guess);
        String s = "" + a + "A" + b + "B";
        return s;
    }

    public static int getA(String secret, String guess) {
        int res = 0;
        int len = secret.length();
        for (int i = 0; i < len; i++) {
            if (secret.charAt(i) == guess.charAt(i)) res++;
        }
        return res;
    }

    public static int getB(String secret, String guess) {
        int res = 0;
        int len = secret.length();
        int dp[] = new int[10];
        for (int i = 0; i < len; i++) {
            int a = secret.charAt(i) - '0';
            dp[a] ++;
            if (secret.charAt(i) == guess.charAt(i))dp[a]--;
        }
        for (int i = 0; i < len; i++) {
            int a = guess.charAt(i) - '0';
            if (dp[a] >0 && (secret.charAt(i) != guess.charAt(i))) {
                res++;
                dp[a]--;
            }
        }
        return res;
    }
}
