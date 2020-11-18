package NC;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: LRU缓存
 * @author: Desmand
 * @time: 2020/11/18 2:16 下午
 */

public class NC93 {
    public static class LRUCache {
        int capacity;
        Map<Integer, Integer> map;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new LinkedHashMap<>();
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            // 先删除旧的位置，再放入新位置
            Integer value = map.remove(key);
            map.put(key, value);
            return value;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.remove(key);
                map.put(key, value);
                return;
            }
            map.put(key, value);
            // 超出capacity，删除最久没用的,利用迭代器删除第一个
            if (map.size() > capacity) {
                map.remove(map.entrySet().iterator().next().getKey());
            }
        }
    }

    public static int[] LRU(int[][] operators, int k) {
        // write code here
        LRUCache lr = new LRUCache(k);
        ArrayList<Integer> list = new ArrayList<>();
        for (int[] arr : operators) {
            if (arr[0] == 1) {
                lr.put(arr[1], arr[2]);
            } else if (arr[0] == 2) {
                list.add(lr.get(arr[1]));
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    public static void main(String[] args) {
        int[][] o = {{1, 1, 1}, {1, 2, 2}, {1, 3, 2}, {2, 1}, {1, 4, 4}, {2, 2}};
        int k = 3;
        int[]ans = LRU(o,k);
        for(int i : ans){
            System.out.print(i+" ");
        }
    }
}
