package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/2/15 10:09 上午
 */

public class LC25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur != null) {
            recursive(cur, k);
            int u = k;
            while (u-- > 0 && cur != null) cur = cur.next;

        }
        return dummy.next;
    }

    void recursive(ListNode root, int k) {
        int u = k;
        ListNode cur = root;
        while (u-- > 0 && cur != null) cur = cur.next;
        if (cur == null) return;
        ListNode a = root.next, b = a.next, tail = cur.next;
        while (k-- > 1) {
            ListNode c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        root.next.next = tail;
        root.next = a;
    }
}
