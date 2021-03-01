package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/2/22 12:31 下午
 */

public class LC30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0) return ans;
        HashMap<String, Integer> map = new HashMap<>();
        for (String ss : words) {
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        int m = words.length;
        int w = words[0].length();
        int len = s.length();
        out: for (int i = 0; i <= len - m * w; i++) {
            String curS = s.substring(i, i + m * w);
            HashMap<String, Integer> cur = new HashMap<>();
            for (int j = 0; j < curS.length(); j += w) {
                String curSubS = curS.substring(j, j + w);
                if (!map.containsKey(curSubS)) continue out;
                cur.put(curSubS, cur.getOrDefault(curSubS, 0) + 1);
            }
            if (cmp(map, cur)) ans.add(i);
        }
        return ans;
    }

    boolean cmp(HashMap<String, Integer> map, HashMap<String, Integer> cur) {
        if (map.size() != cur.size()) return false;
        for (String key : map.keySet()) {
            if (!cur.containsKey(key) || !map.get(key).equals(cur.get(key))) {
                return false;
            }
        }
        for (String key : cur.keySet()) {
            if (!map.containsKey(key) || !map.get(key).equals(cur.get(key))) {
                return false;
            }
        }
        return true;
    }
}
