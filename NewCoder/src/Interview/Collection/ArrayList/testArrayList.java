package Interview.Collection.ArrayList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;

public class testArrayList {
    public static void main(String[] args) {
        //ArrayList<Integer> list = new ArrayList(Collections.nCopies(60, 0));
        ArrayList<Integer> list = new ArrayList(10);
        System.out.println(list.size());
        int n = 100;
        while(n-->0){
            list.add(1);
        }

        Class<ArrayList> arrayListClass = ArrayList.class;
        try {
            //获取 elementData 字段
            Field field = arrayListClass.getDeclaredField("elementData");
            //开始访问权限
            field.setAccessible(true);
            //把示例传入get，获取实例字段elementData的值
            Object[] objects = (Object[])field.get(list);
            //返回当前ArrayList实例的容量值
            System.out.println("当前容量为："+objects.length);;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }


        System.out.println(list.size());
//        System.out.println(list);
        System.out.println(list);
//        list.set(5,1);
//        System.out.println(list.get(5));
    }
}
