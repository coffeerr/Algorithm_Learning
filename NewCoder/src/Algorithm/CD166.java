package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description:找到二叉树中的最大搜索二叉子树
 * @author: Desmand
 * @time: 2020/10/24 8:35 上午
 */

public class CD166 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
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
        int fa, lth, rth;
        fa = nextInt();
        lth = nextInt();
        rth = nextInt();
        if (fa == 0) return null;
        TreeNode node = new TreeNode(fa);
        if (lth != 0) {
            node.left = read();
        }
        if (rth != 0) {
            node.right = read();
        }
        return node;
    }

    public static class ReturnType {
        public TreeNode BSTHead;
        public int BSTSize;
        public int min;
        public int max;

        public ReturnType(TreeNode BSTHead, int BSTSize, int min, int max) {
            this.BSTHead = BSTHead;
            this.BSTSize = BSTSize;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnType process(TreeNode head) {

        if (head == null) {
            return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        ReturnType lData = process(head.left);
        ReturnType rData = process(head.right);
        int min = Math.min(head.val, Math.min(lData.min, rData.min));
        int max = Math.max(head.val, Math.max(lData.max, rData.max));
        TreeNode BSTHead = lData.BSTSize > rData.BSTSize ? lData.BSTHead : rData.BSTHead;
        int BSTSize = lData.BSTSize >= rData.BSTSize ? lData.BSTSize : rData.BSTSize;
        if (lData.BSTHead == head.left && rData.BSTHead == head.right && lData.max < head.val && rData.min > head.val) {
            BSTHead = head;
            BSTSize = lData.BSTSize + rData.BSTSize + 1;
        }

        return new ReturnType(BSTHead, BSTSize, min, max);
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        TreeNode node = read();
        ReturnType returnType = process(node);
        if (returnType.BSTHead == null) {

        } else {
            System.out.println(returnType.BSTSize);
        }
    }
}
