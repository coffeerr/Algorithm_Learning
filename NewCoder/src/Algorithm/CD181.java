package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description: 统计和生成所有不同的二叉树
 * @author: Desmand
 * @time: 2020/11/6 8:55 下午
 */

public class CD181 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int getAns(int num) {
        if (num < 2) return 1;
        int[] arr = new int[num + 1];
        arr[0] = 1;
        int mod = (int) 1e9 + 7;
        for (int i = 1; i < num + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                arr[i] = arr[i] + (arr[j - 1] * arr[i - j]) % mod;
                arr[i] %= mod;
            }
        }
        return arr[num];


    }

    public static void main(String[] args) {
        int n = nextInt();
        System.out.print(getAns(n));
    }
}
