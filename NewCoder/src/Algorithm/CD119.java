package Algorithm;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

//给定一个单链表，实现一个调整单链表的函数，使得每 K 个节点之间的值逆序，
//        如果最后不够 K 个节点一组，则不调整最后几个节点。
public class CD119 {
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
        Node dummyNode = new Node(0);
        Node node = dummyNode;
        for (int i = 0; i < n; i++) {
            node.next = new Node(nextInt());
            node = node.next;
        }
        return dummyNode.next;
    }

    //逆转从该节点开始到第k个节点,并与后置节点连接，循环count次
    public static Node reverseNode(Node head, int k, int count) {
        Node ans = null;
        int i = 0;
        Node lastTail = null;
        Node nextHead = null;
        while (i++ < count) {
            int curK = k;
            Node node = head;
            Node pre = null;
            Node next = null;
            while (curK-- > 0) {
                next = node.next;
                node.next = pre;
                pre = node;
                node = next;
            }
            if (i == 1) {
                ans = pre;
            }
            if (lastTail != null) {
                lastTail.next = pre;
            }
            lastTail = head;
            head.next = node;
            head = node;
            nextHead = head;
        }
        lastTail.next = nextHead;
        return ans;

    }

    //判断当前节点到尾节点数量
    public static int theOtherNode(Node head) {
        int k = 0;
        while (head != null) {
            k++;
            head = head.next;
        }
        return k;
    }

    public static void main(String[] args) {
        int n = nextInt();
        Node head = read(n);
        int k = nextInt();
        if (n >= k && k != 1) {
            head = reverseNode(head, k, n / k);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
