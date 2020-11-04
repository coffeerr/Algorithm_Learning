package LeetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

/**
 * @description: 插入区间
 * @author: Desmand
 * @time: 2020/11/4 9:14 上午
 */

public class LC57 {
    //    public static int[][] insert(int[][] intervals, int[] newInterval) {
//        int[] ans = new int[2];
//        //find the startInterval
//        for (int i = 0; i < intervals.length; i++) {
//            if (intervals[i][0] <= newInterval[0] && intervals[i][1] >= newInterval[0]) {
//                ans[0] = i;
//
//            }
//            if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[1]) {
//                ans[1] = i;
//
//            }
//        }
//        ArrayList<int[]> list = new ArrayList<>();
//        int[] temp = new int[2];
//        for (int i = 0; i < intervals.length; i++) {
//            if (i < ans[0]) {
//                list.add(intervals[i]);
//            } else if (i == ans[0]) {
//
//                temp[0] = Math.min(intervals[i][0], newInterval[0]);
//            } else if (i == ans[1]) {
//                temp[1] = Math.max(intervals[i][1], newInterval[1]);
//                list.add(temp);
//            } else if (i > ans[1]) {
//                list.add(intervals[i]);
//            }
//        }
//        int[][] arr = new int[list.size()][2];
//        for (int i = 0; i < list.size(); i++) {
//            arr[i] = list.get(i);
//        }
//        return arr;
//    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> list = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        int start = left;
        int end = right;
        int i = 0;
        while (i < intervals.length && intervals[i][1] < left) {
            list.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && intervals[i][0] <= right) {
            start = Math.min(start, Math.min(intervals[i][0], left));
            end = Math.max(end, Math.max(intervals[i][1], right));
            i++;
        }
        list.add(new int[]{start, end});

        while (i < intervals.length && intervals[i][0] > right) {
            list.add(intervals[i]);
            i++;
        }
//        if(i>=intervals.length && left>=intervals[i-1][1]){
//            list.add()
//        }

        int[][] ans = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            ans[j] = list.get(j);
        }
        return ans;
    }

    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static int[][] readInterval(int n) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nextInt();
            arr[i][1] = nextInt();
        }
        return arr;
    }

    public static int[] readTargetInterval() {
        int[] arr = new int[2];
        arr[0] = nextInt();
        arr[1] = nextInt();
        return arr;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int[][] arr = readInterval(n);
        int[] arrTar = readTargetInterval();
        int[][] ans = insert(arr, arrTar);
        for (int[] i : ans) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
