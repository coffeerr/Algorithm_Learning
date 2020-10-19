package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/19 9:27 上午
 */

public class CD161 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static class treeNode {
        public int val;
        public treeNode right;
        public treeNode left;

        public treeNode(int val) {

            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static treeNode read() {
        /**
         * @Description: 二叉树的读入
         * @param []
         * @return Algorithm.CD161.treeNode
         * @author Desmand
         * @Date 2020/10/19
         */
        int fa, lch, rch;
        fa = nextInt();
        lch = nextInt();
        rch = nextInt();
        treeNode rootNode = new treeNode(fa);
        if (lch != 0) {
            rootNode.left = read();
        }
        if (rch != 0) {
            rootNode.right = read();
        }
        return rootNode;
    }

    public static void preOrderRecur(treeNode node) {
        /**
         * @Description: 先序遍历二叉树（递归）
         * @param []
         * @return void
         * @author Desmand
         * @Date 2020/10/19
         */
        if (node == null) {
            return;
        }
        if (node != null) {
            System.out.print(node.val + " ");
            preOrderRecur(node.left);
            preOrderRecur(node.right);
        }

    }

    public static void inOrderRecur(treeNode node) {
        /**
         * @Description: 中序遍历二叉树（递归）
         * @param [node]
         * @return void
         * @author Desmand
         * @Date 2020/10/19
         */
        if (node == null) return;
        if (node != null) {
            inOrderRecur(node.left);
            System.out.print(node.val + " ");
            inOrderRecur(node.right);
        }
    }

    public static void posOrderRecur(treeNode node) {
        /**
         * @Description: 后序遍历二叉树（递归）
         * @param [node]
         * @return void
         * @author Desmand
         * @Date 2020/10/19
         */
        if (node == null) return;
        if (node != null) {
            posOrderRecur(node.left);
            posOrderRecur(node.right);
            System.out.print(node.val + " ");
        }
    }

    public static void preOrderStack(treeNode node) {
        /**
         * @Description: 先序遍历二叉树（非递归）
         * @param [node]
         * @return void
         * @author Desmand
         * @Date 2020/10/19
         */
        if (node != null) {
            Stack<treeNode> stack = new Stack<>();
            stack.push(node);
            while (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }
        }
    }

    public static void inOrderStack(treeNode node) {
        /**
         * @Description: 中序遍历二叉树(非递归)
         * @param [node]
         * @return void
         * @author Desmand
         * @Date 2020/10/19
         */
        if (node != null) {
            Stack<treeNode> stack = new Stack<>();
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    System.out.print(node.val + " ");
                    node = node.right;
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        treeNode node = read();
        //先序遍历二叉树（递归）
        //System.out.print("PreOrder: ");
        preOrderStack(node);
        System.out.println();
        //中序遍历二叉树（递归
        //System.out.print("InOrder: ");
        inOrderStack(node);
        System.out.println();
        //后序遍历二叉树（递归
        //System.out.print("PosOrder: ");
        posOrderRecur(node);
        //System.out.println();
        //System.out.println("------非遍历专场------");
//        preOrderStack(node);
//        System.out.println();
//        inOrderStack(node);
    }
}
