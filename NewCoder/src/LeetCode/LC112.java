package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/7 10:52 上午
 */

public class LC112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum);

    }

    public static boolean dfs(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.right == null && root.left == null) {
            if (sum == root.val) {
                return true;
            }
        }
        return dfs(root.left, sum - root.val) ||
                dfs(root.right, sum - root.val);
    }
}
