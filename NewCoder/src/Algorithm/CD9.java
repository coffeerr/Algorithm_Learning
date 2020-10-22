package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;

/**
 * @description: 未排序数组中累加和为给定值的最长子数组长度
 * @author: Desmand
 * @time: 2020/10/22 2:09 下午
 */

public class CD9 {
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
        /**
         * @Description:
         * 这道题关键点在于，要知道s(i) - s(j) = arr[j+1]+...+arr[i]
         * map里存放了sum(i)-i的key-value键值对，如果sum(i) - sum(j) == k
         * 则代表当前的子数组满足条件只需要判断map.containsKey(sum(i)-k)就可以
         * @param [arr, k]
         * @return int
         * @author Desmand
         * @Date 2020/10/22
         */
        int len = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        //算上arr[0]
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return len;

    }

    public static void main(String[] args) {
        int n = nextInt();
        int k = nextInt();
        int[]arr = read(n);
        int len = getMaxLength(arr,k);
        System.out.println(len);

    }
}
