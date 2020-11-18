package NC;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/18 2:59 下午
 */

public class NC93_3 {
    public static class DoubleNode {
        int key;
        int val;
        DoubleNode next;
        DoubleNode pre;

        public DoubleNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.pre = null;
        }
    }

    public static class LRUCache {
        private int capacity;
        private HashMap<Integer, DoubleNode> map;
        //head始终指向优先级最低的节点
        private DoubleNode head;
        //tail前一个节点始终为优先级最高的节点
        private DoubleNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new DoubleNode(-1, -1);
            tail = new DoubleNode(-1, -1);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            //删除节点
            DoubleNode node = map.get(key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
            moveToTail(node);
            //返回
            return node.val;
        }

        private void moveToTail(DoubleNode node) {
            node.pre = tail.pre;
            tail.pre = node;
            node.pre.next = node;
            node.next = tail;
        }

        public void put(int key, int val) {
            if (get(key) != -1) {
                map.get(key).val = val;
                return;
            }
            DoubleNode node = new DoubleNode(key, val);
            map.put(key, node);
            moveToTail(node);
            if (map.size() > capacity) {
                //删除节点
                map.remove(head.next.key);
                head.next = head.next.next;
                head.next.pre = head;
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
        int[] ans = LRU(o, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}
