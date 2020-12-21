package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/21 10:05 上午
 */

public class LC337 {
    Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) return 0;
        if (map.containsKey(root)) {
            return map.get(root);
        }
        int do_it = root.val + (root.left == null ? 0 :
                rob(root.left.left) + rob(root.left.right)) + (root.right == null ? 0 :
                rob(root.right.left) + rob(root.right.right));
        int not_do = rob(root.left) + rob(root.right);
        int res = Math.max(do_it, not_do);
        map.put(root, res);
        return res;
    }
}
