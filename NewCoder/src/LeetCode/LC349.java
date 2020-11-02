package LeetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description: LC349 两个数组的交集
 * @author: Desmand
 * @time: 2020/11/2 2:33 下午
 */

public class LC349 {
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

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map.get(nums1[i]) == null) {
                map.put(nums1[i], 1);
            }
        }
        for (int j = 0; j < nums2.length; j++) {
            if (map.get(nums2[j]) == null) continue;
            if (map.get(nums2[j]) == 1) {
                map.put(nums2[j], -1);
            }
        }
        for (int i : map.keySet()) {
            if (map.get(i) == -1) {
                arr.add(i);
            }
        }


        int[] ans = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n1 = nextInt();
        int n2 = nextInt();
        int[] arr1 = read(n1);
        int[] arr2 = read(n2);
        int[] ans = intersection(arr1, arr2);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
