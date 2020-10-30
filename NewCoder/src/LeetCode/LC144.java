package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树前序遍历
 * @author: Desmand
 * @time: 2020/10/27 10:13 上午
 */

public class LC144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return null;

        return list;
    }

    public static void preOrderCur(TreeNode node) {
        if (node == null) return;
        else {
            System.out.println(node.val + " ");
            preOrderCur(node.left);
            preOrderCur(node.right);
        }
    }
    public static List<Integer> preOrderByStack(TreeNode node){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(node!=null)return null;
        TreeNode head;
        stack.push(node);
        while(!stack.isEmpty()){
            head = stack.pop();
            list.add(head.val);
            if(head.left!=null){
                stack.push(head.left);
            }
            if(head.right!=null){
                stack.push(head.right);
            }
        }
        return list;
    }


}
