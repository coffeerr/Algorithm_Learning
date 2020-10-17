package Interview.Collection.ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class testArrayList {
    public static void main(String[] args) {
        //ArrayList<Integer> list = new ArrayList(Collections.nCopies(60, 0));
        ArrayList<Integer> list = new ArrayList(10);
        int n = 11;
        while(n-->0){
            list.add(1);
        }
        System.out.println(list.size());
        System.out.println(list);
//        list.set(5,1);
//        System.out.println(list.get(5));
    }
}
