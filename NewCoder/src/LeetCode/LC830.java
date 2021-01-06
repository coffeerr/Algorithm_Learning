package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/5 8:47 上午
 */

public class LC830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new ArrayList<>();
        //双指针，快速贴合
        int l = 0, r = 0;
        int n = s.length();
        while (r <= n) {
            if (r == n || s.charAt(l) != s.charAt(r)) {
                if (r - l > 2) {
                    list.add(Arrays.asList(l, r - 1));
                }
                l = r;
            }
            r++;
        }
        return list;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(new LC830().largeGroupPositions(s));
    }
}
