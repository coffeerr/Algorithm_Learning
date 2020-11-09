package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description: 矩阵的最小路径和
 * @author: Desmand
 * @time: 2020/11/7 6:45 下午
 */

public class CD186 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] read(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[j][i] = nextInt();
            }
        }
        return arr;
    }

    public static int getAns(int[][] arr) {
        int row = arr.length;
        int col = arr[0].length;
        if (arr == null || row == 0 || col == 0 || arr[0] == null) {
            return 0;
        }

        int[][] dp = new int[row][col];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < col; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }
        for (int j = 1; j < row; j++) {
            dp[j][0] = dp[j - 1][0] + arr[j][0];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }

    public static void main(String[] args) {
        int n = nextInt();
        int m = nextInt();
        int[][] arr = read(n, m);

        System.out.print(getAns(arr));
    }
}
