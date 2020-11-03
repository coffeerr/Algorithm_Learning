package LeetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

/**
 * @description: 有效的山脉数组
 * @author: Desmand
 * @time: 2020/11/3 9:09 上午
 */

public class LC941 {
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

    public static boolean validMountainArray(int[] A) {
        if (A.length < 3) return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (map.get(A[i]) == null) {
                map.put(A[i], i);
            }
        }
        for (int i : map.keySet()) {
            if (max < i) {
                max = i;
            }
        }
        int flag = map.get(max);
        if (flag == A.length - 1 || flag == 0) return false;

        int cur = A[0];
        for (int j = 1; j <= flag; j++) {
            if (cur >= A[j]) {
                return false;
            } else {
                cur = A[j];
            }
        }
        for (int j = flag+1; j < A.length; j++) {
            if (cur <= A[j]) {
                return false;
            } else {
                cur = A[j];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int[]arr = read(n);
        System.out.print(validMountainArray(arr));
    }
}
