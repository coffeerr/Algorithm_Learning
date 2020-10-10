import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Scanner;
import java.util.Stack;

//假设链表中每一个节点的值都在 0 - 9 之间，那么链表整体就可以代表一个整数。
//给定两个这种链表，请生成代表两个整数相加值的结果链表。
//例如：链表 1 为 9->3->7，链表 2 为 6->3，最后生成新的结果链表为 1->0->0->0。
public class CD114 {
    private static StreamTokenizer st = new StreamTokenizer(new BufferedReader(
            new InputStreamReader(System.in)));

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

    public static class Node {
        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node getAns(Node head1, Node head2) {
        //首先建立两个栈，存储
        Stack<Integer> stack1 = new Stack<Integer>();
        Stack<Integer> stack2 = new Stack<Integer>();
        while (head1 != null) {
            stack1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.val);
            head2 = head2.next;
        }
        //两个栈相加，使用尾插法建立链表
        int carry = 0;
        Node tail = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int sum = stack1.pop() + stack2.pop() + carry;
            if (carry > 0) carry--;
            if (sum >= 10) {
                sum -= 10;
                carry++;
            }
            Node pre = new Node(sum);
            pre.next = tail;
            tail = pre;
        }
        int h1 = 0;
        int h2 = 0;
        int ca = carry;
        int sum;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            h1 = stack1.isEmpty() ? 0 : stack1.pop();
            h2 = stack2.isEmpty() ? 0 : stack2.pop();
            sum = h1 + h2 + carry;
            carry = sum / 10;
            Node pre = new Node(sum % 10);
            pre.next = tail;
            tail = pre;
        }
        if (carry > 0) {
            Node pre = new Node(carry);
            pre.next = tail;
            tail = pre;
        }
        return tail;
    }

    public static void main(String[] args) {
        int n1 = nextInt(), n2 = nextInt();
        Node head1 = read(n1);
        Node head2 = read(n2);
        Node head = getAns(head1, head2);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

    }
}

