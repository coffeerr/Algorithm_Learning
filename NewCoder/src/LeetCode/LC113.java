package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/7 10:18 上午
 */

public class LC113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resList = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), resList);
        return resList;
    }

    public static void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> resList) {
        if (root == null) return;
        List<Integer> subList = new ArrayList<>(list);
        subList.add(new Integer(root.val));
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                resList.add(subList);
                return;
            }
        }
        dfs(root.left, sum - root.val, subList, resList);
        dfs(root.right, sum - root.val, subList, resList);
    }
}
