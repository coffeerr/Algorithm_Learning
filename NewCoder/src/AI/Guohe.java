package AI;
import java.util.Stack;

public class Guohe {

    static boolean  flag = true;
    static Stack<String> visit = new Stack<String>();

    
    private static boolean dfs(int M, int C, int m, int c) {

        if (M < 0 || C < 0 || m < 0 || c < 0) // 非法
            return false;
        if ((M > 0 && C > M) || (m > 0 && c > m)) // 野人会吃牧师
            return false;
        if (flag && M == 0 && C == 0 || (!flag && m == 0 && c == 0)) // 全部运输过去
            return true;
        String str = "";
        if (!flag) {
            str = "M=" + M + ",C=" + C + ",m=" + m + ",c=" + c + ",boat=left";
        } else {
            str = "M=" + m + ",C=" + c + ",m=" + M + ",c=" + C + ",boat=right";
        }
        if (visit.contains(str)) { // 该状态已经搜索过了
            return false;
        }

        visit.push(str);
        flag = !flag;
        if(dfs( m+2, c, M-2,C) ){
            System.out.println("1--" + str);
            return true;
        }
        else if( dfs( m, c+2, M, C-2) ){
            System.out.println("2--" + str);
            return true;
        }
        else if( dfs( m+1, c+1, M-1, C-1) ){
            System.out.println("3--" + str);
            return true;
        }
        else if( dfs( m+1, c, M-1, C)){
            System.out.println("4--" + str);
            return true;
        }
        else if( dfs( m, c+1, M, C-1)){
            System.out.println("5--" + str);
            return true;
        }
        flag = !flag;
        visit.pop();
        return false;
    }
    public static void main(String []args) {
        int M = 3;
        int C = 3;
        int m = 0;
        int c = 0;
        String str = "M=" + M + ",C=" + C + ",m=" + m + ",c=" + c + ",boat=left";
        visit.push(str);
        System.out.println(str);
        if (!dfs(M, C, m, c)) {
            System.out.println("Can not find the solution");
        }
    }
} 