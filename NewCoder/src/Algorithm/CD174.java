package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 判断一棵二叉树是否为搜索二叉树和完全二叉树
 * @author: Desmand
 * @time: 2020/11/1 7:56 上午
 */

public class CD174 {
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

    public static boolean inOrderCur(TreeNode node) {
        int max = Integer.MIN_VALUE;
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    if (node.val > max) {
                        max = node.val;
                    } else {
                        return false;
                    }
                    //System.out.print(node.val + " ");
                    node = node.right;
                }
            }
        }
        return true;
    }

    public static boolean orderByLevel(TreeNode node) {
        if (node == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        TreeNode head;
        boolean hasNode = false;
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
            if (head.left == null && head.right != null) return false;
            if (hasNode && (head.left != null || head.right != null)) {
                return false;
            }
            if (head.right == null) {
                hasNode = true;
            } else {
                hasNode = false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        TreeNode node = read();
        System.out.println(inOrderCur(node));
        System.out.println(orderByLevel(node));
    }
}