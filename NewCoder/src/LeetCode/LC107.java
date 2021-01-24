package LeetCode;

import Algorithm.CD172;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/20 12:03 下午
 */

public class LC107 {
    //给定一个二叉树，返回其节点值自底向上的层序遍历。
    //（即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
                levelList.add(curNode.val);
            }
            list.add(new ArrayList<>(levelList));
        }
        //reverse
        int size = list.size();
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < size / 2; i++) {
            tempList = list.get(i);
            list.set(i, list.get(size - 1 - i));
            list.set(size - 1 - i, tempList);
        }
        return list;
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

    public static void main(String[] args) {
        TreeNode root = read();
        System.out.println(new LC107().levelOrderBottom(root));
    }
}
