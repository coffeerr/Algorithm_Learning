package LeetCode;

import java.util.*;

/**
 * @description: 二叉树的右视图
 * @author: Desmand
 * @time: 2020/11/25 2:20 下午
 */

public class LC199 {
    public List<Integer> rightSideView(TreeNode root) {
        //DFS做法
        Map<Integer, Integer> map = new HashMap<>();
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(0);
        int maxDepth = -1;
        TreeNode curNode;
        while (!nodeStack.isEmpty()) {
            curNode = nodeStack.pop();
            int depth = depthStack.pop();
            if (curNode != null) {
                maxDepth = Math.max(maxDepth, depth);
                if (!map.containsKey(maxDepth)) {
                    map.put(maxDepth, curNode.val);
                }
                nodeStack.push(curNode.left);
                nodeStack.push(curNode.right);
                depthStack.push(depth + 1);
                depthStack.push(depth + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            list.add(map.get(i));
        }
        return list;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        //BFS
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.offer(root);
        depthQueue.offer(0);
        int maxDepth = -1;
        TreeNode curNode;
        int depth;
        while (!nodeQueue.isEmpty()) {
            curNode = nodeQueue.remove();
            depth = depthQueue.remove();
            if (curNode != null) {
                maxDepth = Math.max(depth, maxDepth);
                map.put(maxDepth, curNode.val);
                nodeQueue.offer(curNode.left);
                nodeQueue.offer(curNode.right);
                depthQueue.offer(depth + 1);
                depthQueue.offer(depth + 1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= maxDepth; i++) {
            list.add(map.get(i));
        }
        return list;
    }
}
