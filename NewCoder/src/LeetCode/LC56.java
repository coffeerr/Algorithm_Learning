package LeetCode;

import java.util.Arrays;

/**
 * @description: 合并区间
 * @author: Desmand
 * @time: 2020/12/11 10:35 上午
 */

public class LC56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        int idx = -1;
        int[][] res = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
