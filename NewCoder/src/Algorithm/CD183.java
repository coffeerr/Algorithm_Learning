package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description: 斐波那契数列问题的递归和动态规划
 * @author: Desmand
 * @time: 2020/11/7 8:57 上午
 */

public class CD183 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    public static final int mod = (int) (1e9 + 7);
    //public static int[] arr = new int[(int) 1e18];

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int getF(int n) {
        if (n == 1) return 1;
        if (n == 2) return 1;
        return getF(n - 1) + getF(n - 2);
    }

    public static void main(String[] args) {
        int n = nextInt();
        System.out.print(getF(n)%mod);
    }
}
