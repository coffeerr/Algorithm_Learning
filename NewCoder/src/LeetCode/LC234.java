package LeetCode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/12/9 9:18 上午
 */

public class LC234 {
    public boolean isPalindrome(ListNode head) {
        //快慢指针
        if (head == null) return true;
        if (head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //翻转链表
        ListNode curNode = slow.next;
        ListNode pre = null;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = pre;
            pre = curNode;
            curNode = next;
        }
        while (pre != null) {
            if (pre.val != head.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;


    }
}
