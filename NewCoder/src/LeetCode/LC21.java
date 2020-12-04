package LeetCode;

/**
 * @description: 合并两个有序链表
 * @author: Desmand
 * @time: 2020/12/3 12:53 下午
 */

public class LC21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode head = new ListNode(0);
        ListNode returnHead = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                head.next = l1;
                l1 = l1.next;
                head = head.next;
            } else {
                head.next = l2;
                l2 = l2.next;
                head = head.next;
            }
        }
        while (l1 != null || l2 != null) {
            head.next = l1 != null ? l1 : l2;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            head = head.next;
        }
        return returnHead.next;
    }
}
