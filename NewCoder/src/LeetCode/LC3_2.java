package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/20 8:54 上午
 */

public class LC3_2 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.equals("") || s == null) return 0;
        if(s.length()==1)return 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        int left = 0, right = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            while (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(++right));
            }
            ans = Math.max(right - i + 1, ans);
            set.remove(s.charAt(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
