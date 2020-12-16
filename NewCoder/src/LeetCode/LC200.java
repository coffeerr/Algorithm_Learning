package LeetCode;

/**
 * @description:岛屿数量
 * @author: Desmand
 * @time: 2020/12/16 3:04 下午
 */

public class LC200 {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid.length;
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '0') {
                    dfs(grid, row, col);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
                || grid[row][col] == '1') return;
        grid[row][col] = '1';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }
}
