package Interview.Collection;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/3 9:40 上午
 */

public class Enum {
    public enum Season {
        SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
        private int number = 0;

        private Season(int number) {
            this.number = number;
        }
    }

    public static void main(String[] args) {
        System.out.println(Season.SPRING.ordinal());
    }
}
