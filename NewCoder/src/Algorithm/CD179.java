package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description: 二叉树节点间的最大距离
 * @author: Desmand
 * @time: 2020/11/3 7:58 下午
 */

public class CD179 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode read() {
        int fal = nextInt();
        int lth = nextInt();
        int rth = nextInt();
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

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        TreeNode node = read();
        System.out.println(process(node).maxNodeSize);
    }
}
