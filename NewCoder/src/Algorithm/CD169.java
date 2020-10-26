package Algorithm;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

/**
 * @description: 找到搜索二叉树中两个错误的节点
 * @author: Desmand
 * @time: 2020/10/26 9:42 上午
 */

public class CD169 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
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
        int fal, lth, rth;
        fal = nextInt();
        lth = nextInt();
        rth = nextInt();
        TreeNode node = new TreeNode(fal);
        if (lth != 0) {
            node.left = read();
        }
        if (rth != 0) {
            node.right = read();
        }
        return node;
    }

    public static TreeNode[] getTwoError(TreeNode node) {
        TreeNode[] arr = new TreeNode[2];
        if (node != null) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (!stack.isEmpty() || node != null) {
                if (node != null) {
                    stack.push(node);
                    node = node.left;
                } else {
                    node = stack.pop();
                    if (pre != null && pre.val > node.val) {
                        arr[0] = (arr[0] == null ? pre : arr[0]);
                        arr[1] = node;
                    }
                    pre = node;
                    node = node.right;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = nextInt();
        int root = nextInt();
        TreeNode node = read();
        TreeNode[] arr = getTwoError(node);
        int min = 0;
        int max = 0;
        min = arr[0].val > arr[1].val ? arr[1].val : arr[0].val;
        max = arr[0].val < arr[1].val ? arr[1].val : arr[0].val;

        System.out.println(min + " " + max);
    }
}
