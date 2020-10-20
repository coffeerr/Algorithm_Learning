public class helloWorld {
    public static void main(String[] args) {
        Integer a = 1000, b = 1000;
        System.out.println(a == b);//1 false
        System.out.println(a.equals(b));
        Integer c = 100, d = 100;
        System.out.println(c == d);//2 true
        System.out.println(new Integer(10)==(new Integer(10)));
        float []f[] = new float[3][];
    }
}
