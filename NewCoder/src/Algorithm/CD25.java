package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @description: 最长递增子序列
 * @author: Desmand
 * @time: 2020/11/12 1:18 下午
 */

public class CD25 {
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

    //    public static ArrayList<Integer> getAns(int[] arr) {
//        if (arr.length == 0 || arr == null) {
//            return null;
//        }
//        int len = arr.length;
//        int dp[] = new int[len + 1];
//        dp[len - 1] = 1;
//        for (int i = len - 2; i >= 0; i--) {
//            //将i到队尾的递增元素个数输出
//            dpAns(arr, dp, i);
//        }
//        //找到最长递增序列开始的元素
//        int max = 0;
//        int tar = -1;
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < dp.length; i++) {
//            max = Math.max(max, dp[i]);
//        }
//        //找到最大子序列的序号的list
//        for (int i = 0; i < dp.length; i++) {
//            if (max == dp[i]) {
//                list.add(i);
//            }
//        }
//        //找到序号中元素值最小的序号
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < list.size(); i++) {
//            min = Math.min(arr[list.get(i)], min);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            if (min == arr[list.get(i)]) {
//                tar = list.get(i);
//            }
//        }
//
//
//        ArrayList<Integer> ans = new ArrayList<>();
//        ans.add(arr[tar]);
//        for (int i = tar + 1; i < len; i++) {
//            if (arr[i] > arr[tar]) {
//                ans.add(arr[i]);
//                tar = i;
//            }
//        }
//        //给出序列
//        return ans;
//    }
//
//    public static void dpAns(int[] arr, int[] dp, int i) {
//        //判断dp[i]是否大于dp[i+1]
//        for (int j = i; j < dp.length - 2; j++) {
//            if (arr[i] < arr[j + 1]) {
//                dp[i] = dp[j + 1] + 1;
//                break;
//            }
//        }
//    }
    public static int[] getDp2(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int l, m, r;
        int right = 0;
        for (int i = 1; i < arr.length; i++) {
            l = 0;
            r = right;
            while (l <= r) {
                m = (l + r) / 2;
                if (arr[i] > ends[m]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;
        }
        return dp;
    }

    public static int[] lis2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[] dp = getDp2(arr);
        return generateLIS(arr, dp);
    }

    public static int[] generateLIS(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        int pre = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
                pre = arr[i];
            } else if (dp[i] == len) {
                if (arr[i] < pre) {
                    pre = arr[i];
                    len = dp[i];
                    index = i;
                }
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                lis[--len] = arr[i];
                index = i;
            }
        }
        return lis;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int[] arr = read(n);
        int[] ans = lis2(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
