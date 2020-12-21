package LeetCode;

import java.util.HashMap;

/**
 * @description: LRU
 * @author: Desmand
 * @time: 2020/12/19 1:18 下午
 */

public class LRUCache {
    //DoubleList  + Map
    private DoubleList cache;
    private HashMap<Integer, Node> map;
    private int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new DoubleList();
        map = new HashMap<>();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        makeRecently(key);
        return node.val;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (cache.size() == cap) {
                removeLastNotUsed();
            }
            addLRU(key, value);
        } else {
            remove(key);
            addLRU(key,value);

        }
    }

    void makeRecently(int key) {
        Node node = map.get(key);
        cache.remove(node);
        cache.addLast(node);
    }

    //添加最近使用的元素
    void addLRU(int key, int val) {
        Node node = new Node(key, val);
        cache.addLast(node);
        map.put(key, node);
    }

    //删除LRU
    void remove(int key) {
        Node node = map.get(key);
        map.remove(key);
        cache.remove(node);
    }

    //删除最久未使用的node
    void removeLastNotUsed() {
        Node node = cache.removeFirst();
        map.remove(node.key);

    }

    class DoubleList {
        private Node tail, head;
        private int size;

        public DoubleList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        void addLast(Node node) {
            node.prev = tail.prev;
            tail.prev.next = node;
            node.next = tail;
            tail.prev = node;
            size++;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeFirst() {
            if (head.next == tail) return null;
            Node res = head.next;
            remove(res);
            return res;
        }

        public int size() {
            return size;
        }
    }

    class Node {
        public int key, val;
        public Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }

    }

}
