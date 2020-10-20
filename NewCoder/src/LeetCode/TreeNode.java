package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/20 11:57 上午
 */


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.right = right;
    }
}