package Interview.Collection.JavaBasic;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/22 5:40 下午
 */

public class test1 {
    public static void main(String[] args) {
//        String a = "abc";
//        String b = "abc";
//        String c = new String("abc");
//
//        System.out.println(a==c);
//
//        Integer m = 1000;
//        Integer n = 1000;
//        System.out.println(m==n);
        ArrayList list = new ArrayList();
        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            Field cap = arrayListClass.getField("elementData");
            cap.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
