package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//不占用空间，采用逆序链表
public class CD114_2 {
    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

    //finished
    public static Node read(int num) {
        Node dummyHead = new Node(0);
        Node pre = dummyHead;
        for (int i = 0; i < num; i++) {
            pre.next = new Node(nextInt());
            pre = pre.next;
        }
        return dummyHead.next;
    }

    //finished
    public static int nextInt() {
        try {
            st.nextToken();
            return (int) st.nval;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Node reverseNode(Node head) {
        Node pre = null;
        while (head != null) {
            Node next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        int h1 = nextInt(), h2 = nextInt();
        Node head1 = reverseNode(read(h1));
        Node head2 = reverseNode(read(h2));
        Node head = reverseNode(addNode(head1, head2));
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static Node addNode(Node head1, Node head2) {
        Node head = new Node(-1);
        Node node = head;
        int sum = 0;
        int h1 = 0;
        int h2 = 0;
        int car = 0;
        Node next = new Node(0);
        while (head1 != null || head2 != null) {
            h1 = head1 == null ? 0 : head1.val;
            h2 = head2 == null ? 0 : head2.val;
            sum = h1 + h2 + car;
            car = sum / 10;
            if (sum >= 10) sum -= 10;
            node.next = new Node(sum);
            node = node.next;
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        if(car > 0){
            node.next = new Node(1);
        }
        return head.next;
    }

}
