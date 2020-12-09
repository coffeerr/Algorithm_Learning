package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/7 10:33 上午
 */

public class LC113_2 {
    //dfs+回溯
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> resList = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), resList);
        return resList;
    }

    public static void dfs(TreeNode root, int sum, List<Integer> list, List<List<Integer>> resList) {
        if (root == null) return;
        list.add(new Integer(root.val));
        if (root.left == null && root.right == null) {
            if (sum == root.val) {
                resList.add(new ArrayList(list));
            }
            list.remove(list.size() - 1);
            return;
        }
        dfs(root.left, sum - root.val, list, resList);
        dfs(root.right, sum - root.val, list, resList);
        list.remove(list.size() - 1);
    }
}
