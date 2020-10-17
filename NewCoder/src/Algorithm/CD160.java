package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;

//按左右半区的方式重新组合单链表
public class CD160 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

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
        return dummyNode.next;
    }

    public static Node assemblingNode(Node head, int n) {
        ArrayList<Node> list = new ArrayList<Node>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int num = 0;
        //1、如果n是偶数
        if (n % 2 == 0) {
            while (num < n / 2) {
                list.get(num).next = list.get(num + n / 2);
                list.get(num + n / 2).next = num < n / 2 - 1 ? list.get(num + 1) : null;
                num++;
            }
        } else {
            //2、如果n是奇数
            while (num < n / 2) {
                list.get(num).next = list.get(num + n / 2);
                list.get(num + n / 2).next = num+1<n/2?list.get(num+1):list.get(num + n / 2+1);
                num++;
            }
        }
        return list.get(0);

    }

    public static void main(String[] args) {
        int n = nextInt();
        Node head = read(n);
        Node node = assemblingNode(head, n);
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
