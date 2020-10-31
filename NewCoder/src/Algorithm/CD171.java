package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Stack;

/**
 * @description: CD171
 * @author: Desmand
 * @time: 2020/10/30 8:11 上午
 */

public class CD171 {
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

    public static boolean isContain(TreeNode t1, TreeNode t2) {
        /**
         * @Description: 主要判断函数
         * @param [t1, t2]
         * @return boolean
         * @author Desmand
         * @Date 2020/10/30
         */
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = null;
        if (t1 == null || t2 == null) return false;
        stack.push(t1);
        while (!stack.isEmpty()) {
            head = stack.pop();
            if (head.right != null) {
                stack.push(head.right);
            }
            if (head.left != null) {
                stack.push(head.left);
            }
            if (head.val == t2.val) {
                return check(head, t2);
            }

        }
        return false;
    }

    public static boolean check(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            if(t1!=null){
               return false;
            }
            return true;
        }
        if (t1 == null || t1.val != t2.val) {
            return false;
        }
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }

    public static void main(String[] args) {
        int n1 = nextInt();
        int root1 = nextInt();
        TreeNode node1 = read();
        int n2 = nextInt();
        int root2 = nextInt();
        TreeNode node2 = read();
        System.out.println(isContain(node1, node2));
    }
}
