package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/8 10:15 上午
 */

public class LC48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i < len; i++) {
            //先转置矩阵
            for (int j = i; j < len; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        //翻转每一行
        for (int i = 0; i < len; i++) {
            //先转置矩阵
            for (int j = 0; j < len / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = temp;
            }
        }
    }
}
