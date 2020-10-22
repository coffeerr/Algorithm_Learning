package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description:未排序正数数组中累加和为给定值的最长子数组的长度
 * @author: Desmand
 * @time: 2020/10/22 12:12 下午
 */

public class CD8 {
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

    public static int getMaxLength(int[] arr, int k) {
        int len = 0;
        int left = 0, right = 0;
        int sum = 0;
        if (arr.length == 0) return 0;
        sum = arr[0];
        while (right < arr.length) {
            if (sum == k) {
                len = Math.max(len, right - left + 1);
                right++;
                if (right == arr.length) break;
                sum += arr[right];
            } else if (sum < k) {
                right++;
                if (right == arr.length) break;
                sum += arr[right];
            } else {
                sum -= arr[left];
                left++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[] arr = read(n);
        int len = getMaxLength(arr,k);
        System.out.println(len);
    }
}
