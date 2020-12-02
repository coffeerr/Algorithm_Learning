package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/1 1:42 下午
 */

public class LC104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int height = Math.max(left, right) + 1;
        return height;
    }
}
