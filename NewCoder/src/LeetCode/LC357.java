package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/13 5:39 下午
 */

public class LC357 {
    List<List<Integer>> list = new ArrayList<>();

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n == 1) return 10;
        backtrack(n, new LinkedList<>(),0);
        return list.size();
    }

    void backtrack(int n, LinkedList<Integer> path, int start) {
        list.add(new ArrayList<>(path));
        for (int i = 0; i < n; i++) {


        }
    }

    public static void main(String[] args) {
        System.out.println(new LC357().countNumbersWithUniqueDigits(4));
    }
}
