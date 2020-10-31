package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description: 判断是否为平衡二叉树
 * @author: Desmand
 * @time: 2020/10/30 11:35 上午
 */

public class CD172 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static TreeNode read() {
        int fal, lth, rth;
        fal = nextInt();
        lth = nextInt();
        rth = nextInt();
        TreeNode node = new TreeNode(fal);
        if (lth != 0) {
            node.left = read();
        }
        if (rth != 0) {
            node.right = read();
        }
        return node;
    }

    public static class ReturnType {
        int level;
        boolean isBalanced;

        public ReturnType(int level, boolean isBalanced) {
            this.level = level;
            this.isBalanced = isBalanced;
        }
    }

    public static ReturnType process(TreeNode node, int level) {
        if (node == null) return new ReturnType(0, true);
        ReturnType left = process(node.left, level + 1);
        ReturnType right = process(node.right, level + 1);
        int height = Math.max(left.level, right.level) + 1;
        boolean isBalancedNode = left.isBalanced && right.isBalanced && (Math.abs(left.level - right.level) <= 1);
        return new ReturnType(height, isBalancedNode);

    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        TreeNode node = read();
        System.out.println(process(node,0).isBalanced);
    }
}
