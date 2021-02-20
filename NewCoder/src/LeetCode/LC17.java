package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/25 11:32 下午
 */

public class LC17 {
    public List<String> letterCombinations(String digits) {
        //result
        List<String> result = new ArrayList<>();
        if(digits.length()==0||digits.equals("")){
            return result;
        }
        //map存储对应的字符
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        backtrack(result,map,digits,0,new StringBuilder());
        return result;
    }

    public static void backtrack(List<String> result, Map<Character, String> map, String digits, int index, StringBuilder combination) {
        if (index == digits.length()) {
            result.add(combination.toString());
            return;
        }
        char dig = digits.charAt(index);
        String letters = map.get(dig);
        int len = letters.length();
        for (int i = 0; i < len; i++) {
            combination.append(letters.charAt(i));
            backtrack(result,map,digits,index+1,combination);
            combination.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        System.out.println(new LC17().letterCombinations("23"));
    }
}
