package LeetCode;

import Algorithm.CD171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 平衡二叉树
 * @author: Desmand
 * @time: 2020/12/2 10:15 上午
 */

public class LC110 {
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

    public boolean isBalanced(TreeNode root) {
        return getHeight(root).isBalanced;

    }

    public static ReturnType getHeight(TreeNode head) {
        if (head == null) {
            return new ReturnType(1, true);
        }
        ReturnType left = getHeight(head.left);
        ReturnType right = getHeight(head.right);
        int h = Math.max(left.height, right.height);
        boolean flag = left.isBalanced && right.isBalanced;
        if (Math.abs(left.height - right.height) <= 1) {
            flag = true && flag;
        } else {
            flag = false && flag;
        }
        return new ReturnType(h+1,flag );
    }

    public static class ReturnType {
        public ReturnType(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }

        int height;
        boolean isBalanced;
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            boolean ret = new LC110().isBalanced(root);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
