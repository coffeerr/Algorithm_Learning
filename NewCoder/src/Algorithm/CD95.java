package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @description: 判断两个字符串是否为变形词
 * @author: Desmand
 * @time: 2020/11/17 1:27 下午
 */

public class CD95 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String s1 = br.readLine();
        String s2 = br.readLine();
        System.out.println(getAns(s1, s2));
    }

    public static boolean isSameShape(char[] s1, char[] s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                int sum = map.get(c);
                map.put(c, sum + 1);
            }
        }
        for (char d : s2) {
            if (map.get(d) == null) {
                return false;
            } else {
                int sum = map.get(d);
                map.put(d, sum - 1);
            }
            if (map.get(d) == 0) {
                map.remove(d);
            }
        }
        return true;
    }

    public static boolean getAns(String str1, String str2) {
        if (str1.equals("") || str2.equals("") || str1 == null || str2 == null|| str1.length()!= str2.length()) {
            return false;
        }
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        return isSameShape(s1, s2);
    }
}
