package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description: 机器人到达指定位置步数
 * @author: Desmand
 * @time: 2020/11/9 8:24 上午
 */

public class CD17 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    public static int walk(int n, int cur, int rest, int p) {
//        /**
//         * @Description:
//         * @param [n, cur, rest, p]
//         *            n-总步数
//         *            cur-当前步数
//         *            rest-剩余步数
//         *            p-最后的终点
//         * @return int
//         * @author Desmand
//         * @Date 2020/11/9
//         */
//        int mod = (int) (1e9 + 7);
//        if (rest == 0) {
//            return cur == p ? 1 : 0;
//        }
//        if (cur == 1) {
//            return walk(n, 2, rest - 1, p)%mod;
//        }
//        if (cur == n) {
//            return walk(n, n - 1, rest - 1, p)%mod;
//        }
//        return (walk(n, cur + 1, rest - 1, p) + walk(n, cur - 1, rest - 1, p))%mod;
//    }
    public static int walk(int n, int cur, int rest, int p) {
        /**
         * @Description:
         * @param [n, cur, rest, p]
         *            n-总步数
         *            cur-当前步数
         *            rest-剩余步数
         *            p-最后的终点
         * @return int
         * @author Desmand
         * @Date 2020/11/9
         */
        int mod = (int) (1e9 + 7);
        int dp[][] = new int[rest + 1][n + 1];
        dp[0][p] = 1;
        for (int i = 1; i <= rest; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2]%mod;
                } else if (j == n) {
                    dp[i][j] = dp[i - 1][n - 1]%mod;
                } else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1])%mod;
                }
            }
        }
        return dp[rest][cur]%mod;
    }

    public static int waysWalk(int n, int cur, int rest, int p) {
        //边界条件
        if (n < 2 || rest < 1 || cur < 1 || cur > n || p < 1 || p > n) {
            return 0;
        }
        return walk(n, cur, rest, p);
    }

    public static void main(String[] args) {
        int n = nextInt();
        int cur = nextInt();
        int rest = nextInt();
        int p = nextInt();
        System.out.println(waysWalk(n, cur, rest, p));
    }
}
