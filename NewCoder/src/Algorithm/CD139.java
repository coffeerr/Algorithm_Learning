package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//实现链表的选择排序
public class CD139 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    //下一个整数
    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Node read(int n) {
        Node dummyNode = new Node(0);
        Node node = dummyNode;
        for (int i = 0; i < n; i++) {
            node.next = new Node(nextInt());
            node = node.next;
        }
        return dummyNode.next;
    }

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }


    public static void selectionSort(Node head) {
        Node cur = head;
        Node min = null;
        while (cur != null) {
            min = cur;
            Node node = cur;
            while (node != null) {
                if (node.val < min.val) {
                    min = node;
                }
                node = node.next;
            }
            int temp = cur.val;
            cur.val = min.val;
            min.val = temp;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int n = nextInt();
        Node head = read(n);
        selectionSort(head);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}
