package JZ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/13 9:23 上午
 */

public class test1 {
    List<List<Integer>> resList = new ArrayList<>();
    List<List<Integer>> testList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        generateList(nums);
        for (List<Integer> subList : testList) {
            backtrack(subList, new LinkedList<Integer>());
            resList.add(new ArrayList<>());
            return resList;
        }
        return resList;
    }

    void generateList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            testList.add(new ArrayList<>(list));
        }
    }

    void backtrack(List<Integer> nums, LinkedList<Integer> path) {
        if (path.size() == nums.size()) {
            resList.add(new LinkedList<Integer>(path));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (path.contains(nums.get(i))) {
                continue;
            }
            path.add(nums.get(i));
            backtrack(nums, path);
            path.removeLast();
        }
    }

    void backtrack(int[] nums, LinkedList<Integer> path) {
        resList.add(new LinkedList<Integer>(path));
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(nums, path);
            path.removeLast();
        }
    }
}
