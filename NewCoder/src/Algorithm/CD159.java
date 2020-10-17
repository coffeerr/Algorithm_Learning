package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//合并有序单链表
public class CD159 {
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

    public static Node mergeNode(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        Node head = head1.val <= head2.val ? head1 : head2;
        Node cur1 = head1;
        Node cur2 = head2;
        Node pre = head;
        Node next = null;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre = cur1;
                cur1 = cur1.next;
            } else {
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1== null ? cur2 : cur1;
        return head;
    }

    public static void main(String[] args) {
        int n1 = nextInt();
        Node head1 = read(n1);
        int n2 = nextInt();
        Node head2 = read(n2);
        Node head = mergeNode(head1,head2);
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }
}
