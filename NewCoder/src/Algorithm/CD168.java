package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 二叉树的按层打印与ZigZag打印
 * @author: Desmand
 * @time: 2020/10/25 9:47 上午
 */

public class CD168 {
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

    //    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
//
//    public static int nextInt() {
//        try {
//            st.nextToken();
//            return (int) st.nval;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static TreeNode read() {
//        int fa, lth, rth;
//        fa = nextInt();
//        lth = nextInt();
//        rth = nextInt();
//        if (fa == 0) return null;
//        TreeNode node = new TreeNode(fa);
//        if (lth != 0) {
//            node.left = read();
//        }
//        if (rth != 0) {
//            node.right = read();
//        }
//        return node;
//    }
    private static int idx;

    public static TreeNode buildTree(int[][] arr, int rootVal) {
        if (arr == null || arr.length == 0 || rootVal == 0) return null;

        TreeNode root = new TreeNode(rootVal);

        idx = 0;
        helpBuildTree(arr, root);

        return root;
    }

    private static void helpBuildTree(int[][] arr, TreeNode node) {
        if (idx >= arr.length) return;

        int index = idx;

        if (arr[index][1] != 0) node.left = new TreeNode(arr[index][1]);
        if (arr[index][2] != 0) node.right = new TreeNode(arr[index][2]);

        if (arr[index][1] != 0) {
            idx++;
            helpBuildTree(arr, node.left);
        }

        if (arr[index][2] != 0) {
            idx++;
            helpBuildTree(arr, node.right);
        }

    }

    public static void orderByLevel(TreeNode head) {
        if (head == null) {
            return;
        }
        int level = 1;
        TreeNode last = head;
        TreeNode nLast = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(head);
        System.out.print("Level " + (level++) + ":");
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.val);
            if (last != head) {
                System.out.print(" ");
            }
            if (head.left != null) {
                queue.offer(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.offer(head.right);
                nLast = head.right;
            }
            if (last == head && !queue.isEmpty()) {
                last = nLast;
                System.out.println();
                System.out.print("Level " + (level++) + ":");
            }
        }
    }

    public static void orderByZigzag(TreeNode head) {
        if (head == null) {
            return;
        }
        int level = 1;
        TreeNode last = head;
        TreeNode nLast = null;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(head);
        System.out.print("Level " + (level++) + " from left to right: ");
        while (!queue.isEmpty()) {
            if (level % 2 != 0) {
                head = queue.pollLast();
                System.out.print(head.val);
                if (last != head) {
                    System.out.print(" ");
                }
                if (head.right != null) {
                    queue.offerLast(head.right);
                    nLast = head.right;
                }
                if (head.left != null) {
                    queue.offerLast(head.left);
                    nLast = head.left;
                }
                if (last == head && !queue.isEmpty()) {
                    last = nLast;
                    System.out.println();
                    System.out.print("Level " + (level++) + " from left to right: ");
                }
            } else {
                head = queue.pollFirst();
                System.out.print(head.val);
                if (last != head) {
                    System.out.print(" ");
                }
                if (head.right != null) {
                    queue.offerFirst(head.right);
                    nLast = head.right;
                }
                if (head.left != null) {
                    queue.offerFirst(head.left);
                    nLast = head.left;
                }
                if (last == head && !queue.isEmpty()) {
                    last = nLast;
                    System.out.println();
                    System.out.print("Level " + (level++) + " from right to left: ");
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
            arr[i][2] = Integer.parseInt(input[2]);

        }

        TreeNode root = buildTree(arr, m);
        orderByLevel(root);
        System.out.println();
        orderByZigzag(root);
    }
}
