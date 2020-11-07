package LeetCode;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/5 4:38 下午
 */

public class LC145 {
    public static List<Integer> posOrderTraversal2(TreeNode node) {
        Deque<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        if (node == null) return list;
        stack.addFirst(node);
        while (!stack.isEmpty()) {
            node = stack.removeFirst();
            list.addFirst(node.val);
            if (node.left != null) {
                stack.addFirst(node.left);
            }
            if (node.right != null) {
                stack.addFirst(node.right);
            }
        }
        return list;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode cur = root;
        TreeNode mosRight = root.left;
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
                    addEdge(cur.left, list);

                }
//                addEdge(cur, list);

            }
            //addEdge(cur, list);
            cur = cur.right;
        }
        addEdge(root, list);
        return list;
    }

    public static void addEdge(TreeNode node, List<Integer> list) {
        TreeNode node2 = reverseRightNode(node);
        TreeNode tail = node2;
        while (tail != null) {
            list.add(tail.val);
            tail = tail.right;
        }
        reverseRightNode(node2);

    }

    public static TreeNode reverseRightNode(TreeNode node) {
        TreeNode pre = null;
        TreeNode next = null;
        while (node != null) {
            next = node.right;
            node.right = pre;
            pre = node;
            node = next;
        }
        return pre;
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
        int fal = nextInt();
        int lth = nextInt();
        int rth = nextInt();
        TreeNode node = new TreeNode(fal);
        if (lth != 0) {
            node.left = new TreeNode(lth);
        }
        if (rth != 0) {
            node.right = new TreeNode(rth);
        }
        return node;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        TreeNode node = read();
//        List<Integer> list = postorderTraversal(node);
        List<Integer> list = posOrderTraversal2(node);
        System.out.println();
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
