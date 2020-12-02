package LeetCode.Model;

import java.util.ArrayList;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/29 1:09 下午
 */

public class IslandProblem {

    public void dfs(int grid[][], int r, int c) {
        if (!isAreas(grid, r, c)) {
            return;
        }
        if (grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 2;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public boolean isAreas(int grid[][], int r, int c) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

    //岛屿的最大面积
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int max = area(grid, i, j);
                res = Math.max(res, max);
            }
        }

        return res;
    }

    int area(int grid[][], int r, int c) {
        if (!isAreas(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        if (grid[r][c] == 1) {
            grid[r][c] = 2;
        }
        return 1 + area(grid, r - 1, c) + area(grid, r, c - 1) + area(grid, r + 1, c)
                + area(grid, r, c + 1);
    }

    //岛屿的周长
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return area2(grid, i, j);
            }
        }
        return 0;
    }

    int area2(int grid[][], int r, int c) {
        if (!isAreas(grid, r, c)) {
            return 1;
        }

        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return area2(grid, r - 1, c) + area2(grid, r, c - 1) + area2(grid, r + 1, c)
                + area2(grid, r, c + 1);
    }

}
