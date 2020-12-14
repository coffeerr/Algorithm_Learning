package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/14 9:38 上午
 */

public class LC111 {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return 0;
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode curNode = queue.poll();
            for (int i = 0; i < size; i++) {
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
                if (curNode.left == null && curNode.right == null) {
                    return depth;
                }
            }
            depth++;
        }
        return depth;
    }
}
