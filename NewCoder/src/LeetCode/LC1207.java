package LeetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * @description: 独一无二的出现次数
 * @author: Desmand
 * @time: 2020/10/28 2:16 下午
 */
class CD1027 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int val = map.get(arr[i]);
                map.put(arr[i], ++val);
            } else {
                map.put(arr[i], 0);
            }
        }
        for (int a : map.keySet()
        ) {
            for (int b : map.keySet()
            ) {
                if (map.get(a) == map.get(b) && a != b) {
                    return false;
                }
            }

        }
        return true;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] arr = stringToIntegerArray(line);

            boolean ret = new CD1027().uniqueOccurrences(arr);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}

