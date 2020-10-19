package Interview.Collection;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/10/18 12:10 下午
 */

public class Basic {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        System.out.println(a == b);
        String m = "hello";
        String m1 = m.intern();
        String m2 = new String("hello");
        System.out.println("m==m1   " + (m == m1) + "");
        System.out.println("m==m2   " + (m == m2) + "");
        System.out.println("m.equals(m1)   " + m.equals(m1));
        System.out.println("m.equals(m2)   " + m.equals(m2));
    }


}
