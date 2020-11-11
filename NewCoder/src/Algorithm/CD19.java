package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @description: 换钱的方法数
 * @author: Desmand
 * @time: 2020/11/10 7:19 下午
 */

public class CD19 {
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

    public static int getMoney(int[] arr, int tar) {
        if(tar<=0)return 0;
        Arrays.sort(arr);
        int count = 0;
        int i = arr.length-1;
        while (tar > 0) {
            count += tar / arr[i];
            tar %= arr[i--];
            if(i<0)return -1;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int tar = nextInt();
        int[] arr = read(n);
        int ans = getMoney(arr,tar);
        System.out.println(ans);
    }
}
