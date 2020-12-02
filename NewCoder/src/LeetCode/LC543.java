package LeetCode;

/**
 * @description: 二叉树的直径
 * 给定一棵二叉树，你需要计算它的直径长度。
 * 一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
 * 这条路径可能穿过也可能不穿过根结点。
 * @author: Desmand
 * @time: 2020/11/30 8:53 上午
 */

public class LC543 {
    //
    static int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        depth(root);
        return ans;
    }

    public static int depth(TreeNode root) {
        if (root == null) return 0;
        int L = depth(root.left);
        int R = depth(root.right);
        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }


    public static class ReturnType {
        public ReturnType(int height, int maxNodeSize) {
            this.height = height;
            this.maxNodeSize = maxNodeSize;
        }

        int height;
        int maxNodeSize;
    }

    public static ReturnType process(TreeNode node) {
        if (node == null) return new ReturnType(0, 0);
        ReturnType left = process(node.left);
        ReturnType right = process(node.right);
        int height = Math.max(left.height, right.height) + 1;
        int maxNodeSize = Math.max((left.height + right.height + 1), Math.max(left.maxNodeSize, right.maxNodeSize));
        return new ReturnType(height, maxNodeSize);
    }
}
