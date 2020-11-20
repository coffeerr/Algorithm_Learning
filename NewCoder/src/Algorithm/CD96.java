package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description: 判断是否为旋转词
 * @author: Desmand
 * @time: 2020/11/19 3:02 下午
 */

public class CD96 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(isXZWord(s1, s2));
    }

    public static String isXZWord(String s1, String s2) {
        if (s1.equals("") || s2.equals("") || s1 == null || s2 == null) {
            return "NO";
        }
        if (s1.length() != s2.length()) {
            return "NO";
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        return getAns(str1, str2);
    }

    public static String getAns(char[] s1, char[] s2) {
        int len = s1.length;
        int start = -1;
        int end = -1;
        for (int i = 0; i < len; i++) {
            if (s1[i] == s2[0]) {
                start = i;
                break;
            }
        }
        int temp = start;
        for (int i = temp; i < len; i++) {
            if (s1[i] == s2[temp]) {
                temp++;
            } else {
                end = i;
            }
        }
        for (int i = 0; i < (end - start + 1); i++) {
            if (s1[i] != s2[start + i]) {
                return "NO";
            }
        }
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (s1[i] != s2[count]) {
                return "NO";
            }
            count++;
        }
        return "YES";
    }
}
