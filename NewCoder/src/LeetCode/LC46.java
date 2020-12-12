package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/12 3:27 下午
 */

public class LC46 {
    List<List<Integer>> track = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new LinkedList<>());
        return track;
    }

    void backtrack(int[] nums, LinkedList<Integer> list) {
        //base case
        if (list.size() == nums.length) {
            track.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //移除路径
            if (list.contains(nums[i])) {
                continue;
            }
            //选择路径
            list.add(nums[i]);
            backtrack(nums, list);
            //剪枝
            list.removeLast();
        }
    }
}
