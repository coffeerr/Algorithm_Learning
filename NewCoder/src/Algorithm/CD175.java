package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

/**
 * @description: 在二叉树中找到一个节点的后继节点
 * @author: Desmand
 * @time: 2020/11/2 8:11 上午
 */

public class CD175 {
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

    public static TreeNode inOrderMorris(TreeNode node, TreeNode target) {
        if (node == null) return null;
        TreeNode cur = node;
        TreeNode mosRight;
        TreeNode next = new TreeNode(0);
        int record = 0;
        while (cur != null) {
            mosRight = cur.left;
            if (mosRight != null) {
                while (mosRight.right != null && mosRight.right != cur) {
                    mosRight = mosRight.right;
                }
                if (mosRight.right == null) {
                    mosRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mosRight.right = null;
                }
            }
            // System.out.print(cur.val + " ");
            if (record == 1) {
                next = cur;
                record = 0;
            }
            if (cur.val == target.val) {
                record = 1;
            }
            cur = cur.right;
        }
        return next;
    }

    public static void inOrderByStack(TreeNode node) {
        TreeNode head;
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    System.out.print(node.val+" ");
                    node = node.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        TreeNode node = read();
        TreeNode tar = new TreeNode(nextInt());
        TreeNode ans = inOrderMorris(node, tar);
        System.out.print(ans.val);

        inOrderByStack(node);
    }
}
