package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树的序列化
 * @author: Desmand
 * @time: 2020/10/20 7:20 下午
 */

public class CD163 {
    public static class treeNode {
        public int val;
        public treeNode left;
        public treeNode right;

        public treeNode(int val) {
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

    public static treeNode read() {
        int fa, lch, rch;
        fa = nextInt();
        lch = nextInt();
        rch = nextInt();
        treeNode node = new treeNode(fa);
        if (lch != 0) {
            node.left = read();
        }
        if (rch != 0) {
            node.right = read();
        }
        return node;
    }

    public static StringBuilder preOrderRecur(treeNode node,StringBuilder sb) {
        if (node == null) {
            return sb.append("#!");
        }
        sb.append(node.val + "!");
        preOrderRecur(node.left,sb);
        preOrderRecur(node.right,sb);
        return sb;
    }

    public static StringBuilder levelOrder(treeNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.val + "!");
        Queue<treeNode> queue = new LinkedList<treeNode>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node.left != null) {
                sb.append(node.left.val + "!");
                queue.offer(node.left);
            } else {
               sb.append("#!");
            }
            if (node.right != null) {
                sb.append(node.right.val + "!");
                queue.offer(node.right);
            } else {
                sb.append("#!");
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        treeNode node = read();
        StringBuilder sb = new StringBuilder();
        StringBuilder preOrderRes = preOrderRecur(node,sb);
        System.out.println(preOrderRes);
        StringBuilder levelOrderRes = levelOrder(node);
        System.out.println(levelOrderRes);
    }
}
