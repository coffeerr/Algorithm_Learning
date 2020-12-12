package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/11 1:54 下午
 */

public class LC6 {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0;i<numRows;i++)list.add(new StringBuilder());
        int i = 0;
        int flag = -1;
        for(char c:s.toCharArray()){
            list.get(i).append(c);
            if(i==0||numRows-i==1)flag = -flag;
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder sb:list)res.append(sb);
        return res.toString();
    }
}
