package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/2 3:29 下午
 */

public class LC94 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode mosRight;
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
                }
            }
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
                list.add(root.val);
            }
        }
        return list;
    }

    public List<Integer> inorderTraversal22(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode cur = root;
        TreeNode mosRight;
        while (cur != null) {
            mosRight = cur.left;
            if (mosRight != null) {
                while (mosRight != null && mosRight.right != cur) {
                    mosRight = mosRight.right;
                }
                if (mosRight.right == null) {
                    mosRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mosRight.right = null;
                }
            }
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}
