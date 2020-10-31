package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description: 根据后序数组重建搜索二叉树
 * @author: Desmand
 * @time: 2020/10/31 8:12 上午
 */

public class CD173 {
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

    public static boolean process(int left, int right, int[] arr) {
        if (left == right) return true;
        if (right - left == 1) return true;
        int middle = findMiddle(left, right, arr);
        if (middle == -2) return false;
        if (middle == -1) return true;
        if (middle == left || middle == right) return true;
        boolean leftA = process(left, middle, arr);
        boolean rightA = process(middle + 1, right, arr);
        return leftA && rightA;
    }

    public static int findMiddle(int left, int right, int[] arr) {
        if (right - left == 1) {
            if (arr[right] > arr[left]) {
                return right;
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i < right; i++) {
            if (arr[right] > arr[i] && arr[right] < arr[i + 1]) {
                return i;
            }
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        if (arr[right] > max) {
            return right - 1;
        }
        if (arr[right] < min) {
            return left - 1;
        }
        return -1;

    }

    public static void main(String[] args) {
        int n = nextInt();
        int[] arr = read(n);
        System.out.print(process(0, n - 1, arr));
    }
}
