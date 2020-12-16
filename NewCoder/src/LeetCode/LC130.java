package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/15 12:39 下午
 */

public class LC130 {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean isEdge = (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1);
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                    //先把边缘的O变成#
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == '#') {
                    board[row][col] = 'O';
                } else if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#'
                || board[i][j] == 'X') return;
        board[i][j] = '#';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }
}
