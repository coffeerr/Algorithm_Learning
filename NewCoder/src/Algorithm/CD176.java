package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description: 在二叉树中找到两个节点的最近公共祖先
 * @author: Desmand
 * @time: 2020/11/3 1:14 下午
 */

public class CD176 {
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

    public static TreeNode lowestAncestor(TreeNode head, TreeNode O1, TreeNode O2) {
        if (head == null || head.val == O1.val || head.val == O2.val) {
            return head;
        }
        TreeNode left = lowestAncestor(head.left, O1, O2);
        TreeNode right = lowestAncestor(head.right, O1, O2);
        if (left != null && right != null) {
            return head;
        }
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        TreeNode node = read();
        TreeNode O1 = new TreeNode(nextInt());
        TreeNode O2 = new TreeNode(nextInt());
        TreeNode ancestor = lowestAncestor(node, O1, O2);
        System.out.println(ancestor.val);
    }
}
