package LeetCode;

import java.util.*;

/**
 * @description: 二叉树的锯齿形遍历
 * @author: Desmand
 * @time: 2020/12/1 11:14 上午
 */

public class LC103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);

            int flag = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                //queue中每一次留下的都是一层的节点
                List<Integer> rem = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    rem.add(cur.val);
                    if (cur.left != null) {
                        queue.add(cur.left);
                    }
                    if (cur.right != null) {
                        queue.add(cur.right);
                    }
                }
                if (flag % 2 == 0) {
                    Collections.reverse(rem);
                }
                list.add(rem);
                flag++;
            }

        }
        return list;
    }
}
