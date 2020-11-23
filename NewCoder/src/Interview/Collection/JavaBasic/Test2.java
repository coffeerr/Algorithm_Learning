package Interview.Collection.JavaBasic;

import java.util.HashSet;

/**
 * @description:测试equal和hashCode
 * @author: Desmand
 * @time: 2020/11/23 8:50 下午
 */

public class Test2 {

    public static void main(String[] args) {
        Student s1 = new Student("小明",10);
        Student s2 = new Student("小明",10);
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode()==s2.hashCode());
        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        for(Student i : set){
            System.out.println(i.getName());
        }
    }

}
