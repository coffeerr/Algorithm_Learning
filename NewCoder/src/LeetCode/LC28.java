package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/2/20 9:01 上午
 */

public class LC28 {
    public int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;
        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;
        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();
        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，j++
            if (p[i] == p[j + 1]) j++;
            next[i] = j;
        }
        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功 j++
            if (s[i] == p[j + 1]) j++;
            // 如果匹配成功了，直接返回
            if (j == m) return i - m;
        }
        return -1;
    }

    public static void main(String[] args) {
        String ss = "aaaaa";
        String pp = "bba";
        System.out.println(new LC28().strStr(ss,pp));

    }
}
