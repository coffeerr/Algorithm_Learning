package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//	向有序的环形单链表中插入新节点
public class CD158 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Node read(int n) {
        Node dummyNode = new Node(-1);
        Node cur = dummyNode;
        for (int i = 0; i < n; i++) {
            cur.next = new Node(nextInt());
            cur = cur.next;
        }
        cur.next = dummyNode.next;
        return dummyNode.next;
    }


    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node insertNode(Node head, int num) {
        //如果链表为空
        if (head == null) {
            Node node = new Node(num);
            node.next = node;
            return node;
        }
        //如果链表不为空
        Node node = new Node(num);
        Node cur = head.next;
        Node pre = head;
        while (cur != head) {
            if (node.val >= pre.val && node.val <= cur.val) {
                pre.next = node;
                node.next = cur;
                return head;
            }
            cur = cur.next;
            pre = pre.next;
        }
        //如果遍历一圈还没有插入，则说明存在两种情况
        //1、num比head还小，此时插入head前。
        if (node.val < head.val) {
            node.next = head;
            pre.next = node;
            return node;
        }
        //2、num比尾巴还大，插入到最后
        if (node.val > pre.val) {
            pre.next = node;
            node.next = head;
            return head;
        }
        return null;

    }

    public static void main(String[] args) {
        int n = nextInt();
        Node head = read(n);
        int num = nextInt();
        Node newHead = insertNode(head, num);
        n++;
        while(n-->0){
            System.out.print(newHead.val+" ");
            newHead = newHead.next;
        }
    }
}
