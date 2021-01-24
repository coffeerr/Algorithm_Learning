package Algorithm;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/24 10:21 下午
 */

public class LC14 {
    //横向
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length==0){
            return "";
        }else if(strs.length==1){
            return strs[0];
        }else if(strs.length==2){
            return twoCommonPrefix(strs[0],strs[1]).toString();
        }
        StringBuilder start = twoCommonPrefix(strs[0],strs[1]);
        for(int i = 2;i < strs.length;i++){
            start = twoCommonPrefix(start.toString(),strs[i]);
        }
        return start.toString();
    }
    public static StringBuilder twoCommonPrefix(String s1,String s2){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<s1.length()&&i<s2.length();i++){
            if(s1.charAt(i)==s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else{
                break;
            }
        }
        return sb;
    }
    //纵向
    public String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        String ans = strs[0];
        for(int i = 1;i<strs.length;i++){
            int j =1;
            for(;j<strs[i].length()&&j<ans.length();j++){
                if(ans.charAt(j)!=strs[i].charAt(j)){
                    break;
                }
            }
            ans = ans.substring(0,j);
            if (ans ==""){
                return "";
            }
        }
        return ans;
    }

}
