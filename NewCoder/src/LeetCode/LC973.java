package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/9 3:58 下午
 */

public class LC973 {
    public int[][] kClosest(int[][] points, int K) {
        HashMap<int[], Double> map = new HashMap<>();
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
        }
        HashMap<Double, Integer> map2 = new HashMap<>();
        int count = 0;
        for (double value : map.values()) {
            map2.put(value, count++);
            list.add(value);
        }
        return null;
    }
    public int[][] kClosest2(int[][] points, int K) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return (point1[0] * point1[0] + point1[1] * point1[1]) - (point2[0] * point2[0] + point2[1] * point2[1]);
            }
        });
        return Arrays.copyOfRange(points, 0, K);
    }

    public static double getDis(int[] arr) {
        double a = Math.sqrt(arr[0] * arr[0] + arr[1] * arr[1]);
        return a;
    }
}
