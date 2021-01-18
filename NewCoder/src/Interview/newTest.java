package Interview;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/8 11:02 上午
 */

public class newTest {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 1;i<=500;i++){
            if(i%3==0 && i%7!=0){
                count++;
                continue;
            }
            if(i%5==0 && i%7!=0){
                count++;
                continue;
            }
        }
        System.out.println(count);
    }
}
