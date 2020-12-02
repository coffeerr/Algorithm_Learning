package LeetCode;

/**
 * @description: 反转部分链表
 * @author: Desmand
 * @time: 2020/11/29 12:26 下午
 */

public class LC92 {
    ListNode successor = null;

    public ListNode reverseN(ListNode head, int n) {

        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

}
