package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/6 8:00 下午
 */

public class LC141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
