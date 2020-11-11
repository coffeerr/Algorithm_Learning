package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description: 换钱的最少货币数
 * @author: Desmand
 * @time: 2020/11/11 5:14 下午
 */

public class CD12 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int[] read(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }

    public static int minCoins1(int[] arr, int rest) {
        if (arr.length == 0 || rest == 0) {
            return 0;
        }
        return process(arr, 0, rest);
    }

    public static int process(int[] arr, int i, int rest) {
        if (i == arr.length) {
            return rest == 0 ? 0 : -1;
        }
        int res = -1;
        for (int k = 0; k * arr[i] <= rest; k++) {
            int next = process(arr, i + 1, rest - k * arr[i]);
            if (next != -1) {
                res = res == -1 ? next + k : Math.min(res, next + k);
            }
        }
        return res;
    }

    public static int minCoins2(int[] arr, int rest) {
        if (arr == null || arr.length == 0 || rest < 0) {
            return -1;
        }
        return processDp(arr, 0, rest);
    }

    public static int processDp(int[] arr, int i, int rest) {
        int[][] dp = new int[arr.length + 1][rest + 1];
        int N = arr.length;
        //dp[arr.length][0] = 0;
        for (int col = 1; col <= rest; col++) {
            dp[N][col] = -1;
        }
        for (int j = N - 1; j >= 0; j--) {
            for (int k = 1; k <= rest; k++) {
                dp[j][k] = -1;
                if (dp[j + 1][k] != -1) {
                    dp[j][k] = dp[j + 1][k];
                }
                if (k - arr[j] >= 0 && dp[j][k - arr[j]] != -1) {
                    if (dp[j][k] == -1) {
                        dp[j][k] = dp[j][k - arr[j]]+1;
                    } else {
                        dp[j][k] = Math.min(dp[j][k], dp[j][k - arr[j]]+1);
                    }
                }
            }
        }
        return dp[0][rest];
    }

    public static void main(String[] args) {
        int n = nextInt();
        int rest = nextInt();
        int[] arr = read(n);
        int ans = minCoins2(arr, rest);
        System.out.println(ans);
    }
}
