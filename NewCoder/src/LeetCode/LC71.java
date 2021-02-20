package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/2/9 12:17 下午
 */

public class LC71 {
    public String simplifyPath(String path) {
        String[] strs = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        if (strs.length == 0) {
            return "/";
        }
        for (String str : strs) {
            if ("".equals(str) || ".".equals(str)) continue;
            if("..".equals(str)&&!stack.isEmpty()){
                stack.removeLast();
                continue;
            }
            stack.addLast(str);
        }
        StringBuilder ans = new StringBuilder("");

        while(!stack.isEmpty()){
            String temp = stack.poll();
            if(temp.equals("..")){
                continue;
            }
            ans.append("/"+temp);
        }
        return ans.toString().equals("")?"/":ans.toString();

    }

    public static void main(String[] args) {
        //System.out.println(new LC71().simplifyPath("/home/"));
        System.out.println(new LC71().simplifyPath("/../"));
        System.out.println(new LC71().simplifyPath("/a/../../b/../c//.//"));
    }
}
