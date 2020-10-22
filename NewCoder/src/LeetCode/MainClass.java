package LeetCode;

import com.eclipsesource.json.Json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//class Solution {
//    public boolean isLongPressedName(String name, String typed) {
//        int i = 0,j = 0;
//        while (j < typed.length()){
//            if(name.charAt(i) == typed.charAt(j)&& i < name.length()){
//                i++;
//                j++;
//            }else if(j>0&&typed.charAt(j) == typed.charAt(j-1)){
//                j++;
//            }else{
//                return false;
//            }
//        }
//        return true;
//    }
//}
class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }
}

public class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return Json.value(input).toString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String name = stringToString(line);
            line = in.readLine();
            String typed = stringToString(line);

            boolean ret = new Solution().isLongPressedName(name, typed);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}