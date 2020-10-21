package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/21 9:43 上午
 */

public class CD164 {
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

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        treeNode node = read();
        preOrderMorris(node);
        System.out.println();
        inOrderMorris(node);
        System.out.println();
        posOrderMorris(node);
    }

    public static void preOrderMorris(treeNode node) {
        if (node == null) return;
        treeNode cur = node;
        treeNode mosRight = null;
        while (cur != null) {
            mosRight = cur.left;
            if (mosRight != null) {
                //让mosRight变成cur左节点的最右节点
                while (mosRight.right != null && mosRight.right != cur) {
                    mosRight = mosRight.right;
                }
                if (mosRight.right == null) {
                    mosRight.right = cur;
                    System.out.print(cur.val + " ");
                    cur = cur.left;
                    continue;
                } else {
                    mosRight.right = null;
                }

            } else {
                System.out.print(cur.val + " ");
            }
            cur = cur.right;
        }
    }

    public static void inOrderMorris(treeNode node) {
        if (node == null) return;
        treeNode cur = node;
        treeNode mosRight = null;
        while (cur != null) {
            mosRight = cur.left;
            if (mosRight != null) {
                //让mosRight变成cur左节点的最右节点
                while (mosRight.right != null && mosRight.right != cur) {
                    mosRight = mosRight.right;
                }
                if (mosRight.right == null) {
                    mosRight.right = cur;
                    //System.out.print(cur.val + " ");
                    cur = cur.left;
                    continue;
                } else {
                    mosRight.right = null;
                }

            }
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
    }

    public static void posOrderMorris(treeNode node) {
        if (node == null) return;
        treeNode cur = node;
        treeNode mosRight = null;
        while (cur != null) {
            mosRight = cur.left;
            if (mosRight != null) {
                //让mosRight变成cur左节点的最右节点
                while (mosRight.right != null && mosRight.right != cur) {
                    mosRight = mosRight.right;
                }
                if (mosRight.right == null) {
                    mosRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mosRight.right = null;
                    printEdge(cur.left);
                }

            }
            // System.out.print(cur.val + " ");
            cur = cur.right;
        }
        printEdge(node);
    }

    public static void printEdge(treeNode node) {
        treeNode tail = reverseEdge(node);
        treeNode cur = tail;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.right;
        }
        reverseEdge(tail);

    }

    public static treeNode reverseEdge(treeNode node) {
        treeNode next = null;
        treeNode pre = null;
        while (node != null) {
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
