package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @description: 信封嵌套问题
 * @author: Desmand
 * @time: 2020/11/13 8:28 上午
 */

public class CD29 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] read(int n) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nextInt();
            arr[i][1] = nextInt();
        }
        return arr;
    }

    public static class Envelope {
        public int len;
        public int wid;

        public Envelope(int len, int wid) {
            this.len = len;
            this.wid = wid;
        }
    }

    public static class EnvelopeComparator implements Comparator<Envelope> {
        @Override
        public int compare(Envelope o1, Envelope o2) {
            //按照长度升序，如果长度一样则按照宽度降序
            return o1.len != o2.len ? o1.len - o2.len : o2.wid - o1.wid;
        }
    }

    //对信封进行排序
    public static Envelope[] getSortedEnvelopes(int[][] matrix) {
        Envelope[] res = new Envelope[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            res[i] = new Envelope(matrix[i][0], matrix[i][1]);
        }
        Arrays.sort(res, new EnvelopeComparator());
        return res;
    }

    //返回按照宽度的最长递增子序列个数
    //暴力
    public static int maxEnvelopes(int[][] matirx) {
        Envelope[] res = getSortedEnvelopes(matirx);
        int[] dp = new int[matirx.length];
        //填充dp数组
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (res[i].wid > res[j].wid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //找到最长序列
        int max = dp[0];
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    //使用end数组
    public static int maxEnvelopes2(int[][] matirx) {
        Envelope[] res = getSortedEnvelopes(matirx);
        int[] ends = new int[matirx.length];
        ends[0] = res[0].wid;
        int right = 0;
        int l, m, r;
        for (int i = 0; i < matirx.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (res[i].wid > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            ends[l] = res[i].wid;
            right = Math.max(right, l);
        }
        return right + 1;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int[][] matrix = read(n);
        int ans = maxEnvelopes2(matrix);
        System.out.print(ans);
    }
}
