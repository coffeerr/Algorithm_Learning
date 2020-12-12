package LeetCode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: n皇后问题
 * @author: Desmand
 * @time: 2020/12/12 3:57 下午
 */

public class LC51 {
    private int n;
    //该列是否放置皇后
    private boolean[] col;
    //主对角是否放置皇后
    private boolean[] main;
    //副对角是否放置皇后
    private boolean[] sub;

    private List<List<String>> ans = new LinkedList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.col = new boolean[n];
        this.main = new boolean[2 * n + 1];
        this.sub = new boolean[2 * n + 1];
        Deque<Integer> path = new LinkedList<>();
        dfs(0, path);
        return ans;
    }

    void dfs(int row, Deque<Integer> path) {
        if ( row==n) {
            ans.add(convert2board(new LinkedList<>(path)));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !main[row - i + n - 1] && !sub[row + i]) {
                path.addLast(i);
                col[i] = true;
                main[row - i + n - 1] = true;
                sub[row + i] = true;
                dfs(row + 1, path);
                col[i] = false;
                main[row - i + n - 1] = false;
                sub[row + i] = false;
                path.removeLast();
            }
        }

    }

    List<String> convert2board(List<Integer> list) {
        List<String> res = new ArrayList<>();
        for (int num : list) {
            StringBuilder row = new StringBuilder();
            for (int i = 0; i < n; i++) {
                row.append('.');
            }
            row.replace(num, num + 1, "Q");
            res.add(row.toString());
        }
        return res;
    }
}
