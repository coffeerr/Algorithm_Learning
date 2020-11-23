package Interview.Collection.JavaBasic;

import java.util.Objects;

public class Student {
    private String name;
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

//    @Override
//    public boolean equals(Object obj) {
//        Student s = (Student) obj;
//        return s.name == name ;
//    }
//
//    @Override
//    public int hashCode() {
//        int name = this.name.hashCode();
//        return name;
//    }
}
