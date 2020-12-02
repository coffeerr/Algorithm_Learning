package Interview.Collection.JavaBasic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/27 10:21 上午
 */


public class ComparableTest1 {

    public static class Person {
        private Integer age;

        public Person(Integer age) {
            this.age = age;
        }

        public Integer getAge() {
            return age;
        }

        static class Student implements Comparable<Student> {
            int sno;
            int score;

            Student(int sno, int score) {
                this.sno = sno;
                this.score = score;
            }

            @Override
            public int compareTo(Student o) {
//            if (this.score < o.score) return -1;
//            else if (this.score > o.score) return 1;
//            else return 0;
                return o.score - this.score;
            }
        }

        public static void main(String[] args) {
            Student s1 = new Student(1, 1);
            Student s2 = new Student(1, 2);
            Student s3 = new Student(1, 3);
            Student s[] = new Student[3];
            s[0] = s1;
            s[1] = s2;
            s[2] = s3;
            Arrays.sort(s);
            for (Student i : s) {
                System.out.println("sno---" + i.sno + "---score---" + i.score);
            }
            TreeMap<Person, String> treeMap = new TreeMap<>(new Comparator<Person>() {
                @Override
                public int compare(Person person1, Person person2) {
                    int num = person1.getAge() - person2.getAge();
                    return Integer.compare(num, 0);
                }
            });
            treeMap.put(new Person(3), "person1");
            treeMap.put(new Person(18), "person2");
            treeMap.put(new Person(35), "person3");
            treeMap.put(new Person(16), "person4");
            treeMap.entrySet().stream().forEach(personStringEntry -> {
                System.out.println(personStringEntry.getValue());
            });

        }

    }

}
