package LeetCode;

import java.util.HashMap;

/**
 * @description: 两数相加
 * @author: Desmand
 * @time: 2020/10/24 7:46 下午
 */

public class LC002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        int cal = 0;
        int sum;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + cal;
            cal = sum / 10;
            cur.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            cur = cur.next;
        }
        while (l1 != null || l2 != null) {
            sum = l1 == null ? l2.val + cal : l1.val + cal;
            cur.next = new ListNode(sum % 10);
            cal = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return head.next;
    }
}
