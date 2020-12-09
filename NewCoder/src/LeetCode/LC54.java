package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 螺旋矩阵
 * @author: Desmand
 * @time: 2020/12/6 9:51 下午
 */

public class LC54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int l = 0;
        int r = matrix[0].length - 1;
        int t = 0;
        int b = matrix.length - 1;
        int num = (r + 1) * (b + 1);
        while (num > 0) {
            for (int i = l; i <= r&&num > 0; i++) {
                list.add(matrix[t][i]);
                num--;
            }
            t++;
            for (int i = t; i <= b&&num > 0; i++) {
                list.add(matrix[i][r]);
                num--;
            }
            r--;
            for (int i = r; i >= l&&num > 0; i--) {
                list.add(matrix[b][i]);
                num--;
            }
            b--;
            for (int i = b; i >= t&&num > 0; i--) {
                list.add(matrix[i][l]);
                num--;
            }
            l++;
        }
        return list;
    }
}
