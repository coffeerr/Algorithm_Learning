package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @description: 在二叉树中找到两个节点的最近公共祖先(进阶)
 * @author: Desmand
 * @time: 2020/11/3 1:14 下午
 */

public class CD177 {
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

    public static int[][] read2(int n) {
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nextInt();
            arr[i][1] = nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        TreeNode node = read();
        int m = nextInt();
        int[][] arr = read2(m);
        Record1 rc = new Record1(node);
       // System.out.println();
        for (int i = 0; i < m; i++) {
            TreeNode O1 = new TreeNode(arr[i][0]);
            TreeNode O2 = new TreeNode(arr[i][1]);
            int ancestor = rc.lowestAncestor(O1, O2);
            System.out.println(ancestor);
        }

    }

    public static class Record1 {
        private static HashMap<Integer, Integer> map = new HashMap<>();

        public Record1(TreeNode head) {
            if (head != null) {
                map.put(head.val, -1);
            }
            setMap(head);
        }

        public void setMap(TreeNode head) {
            if (head == null) {
                return;
            }
            if (head.left != null) {
                map.put(head.left.val, head.val);
            }
            if (head.right != null) {
                map.put(head.right.val, head.val);
            }
            setMap(head.left);
            setMap(head.right);
        }

        public Integer lowestAncestor(TreeNode O1, TreeNode O2) {
            HashSet<Integer> set = new HashSet<>();
            while (map.containsKey(O1.val)) {
                if (map.containsKey(O1.val)) {
                    set.add(map.get(O1.val));
                    O1.val = map.get(O1.val);
                }
            }
            while (!set.contains(O2.val)) {
                O2.val = map.get(O2.val);
            }
            return O2.val;
        }
    }
}
