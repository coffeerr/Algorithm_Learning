package LeetCode;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 无重复字符的最长子串
 * @author: Desmand
 * @time: 2020/10/26 2:43 下午
 */

public class LC3 {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution1().lengthOfLongestSubstring(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }

}

class Solution1 {
    //    public int lengthOfLongestSubstring(String s) {
//        /**
//         * @Description: 使用滑动窗口
//         * @param [s]
//         * @return int
//         * @author Desmand
//         * @Date 2020/10/26
//         */
//        if (s == null) return -1;
//        HashMap<Character, Integer> map = new HashMap<>();
//        int ans = -1, left = 0;
//        int right = -1;
//        while (left < s.length()) {
//            if (left != 0) {
//                map.remove(s.charAt(left - 1));
//            }
//            while (right + 1 < s.length() && !map.containsKey(s.charAt(right + 1))) {
//                map.put(s.charAt(++right), 1);
//            }
//            ans = Math.max(ans, right - left + 1);
//            left++;
//        }
//        //System.out.println(ans-1);
//        return ans;
//    }
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}

