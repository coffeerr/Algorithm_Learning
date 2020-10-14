package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//	一种怪异的节点删除方式
public class CD157 {
    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

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
        Node dummyNode = new Node(0);
        Node node = dummyNode;
        for (int i = 0; i < n; i++) {
            node.next = new Node(nextInt());
            node = node.next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int n = nextInt();
        Node head = read(n);
        Node head2 = head;
        int k = nextInt();
        Node cur = null;
        while (head2 != null) {
            if (--k == 0) {
                cur = head2;
                break;
            }
            head2 = head2.next;
        }

        if (cur == null) {
            return;
        }
        if (cur.next == null) {
            throw new RuntimeException("The node cannot be the last!");
        }
        cur.val = cur.next.val;
        cur.next = cur.next.next;
        while (head != null) {
            System.out.print(head.val);
            if(head.next!=null){
                System.out.print(" ");
            }
            head = head.next;
        }
    }
}
