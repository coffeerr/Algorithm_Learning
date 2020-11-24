package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 环形链表2，不仅需要验证其是为存在环形链表，还需要找到入环点
 * @author: Desmand
 * @time: 2020/11/24 9:26 上午
 */

public class LC142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                for (; ; ) {
                    ptr = ptr.next;
                    slow = slow.next;
                    if (ptr == slow) {
                        return ptr;
                    }
                }
            }
        }
        return null;
    }
    public ListNode detectCycle2(ListNode head) {
        if(head==null)return null;
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while(cur!=null){
            if(set.contains(cur)){
                return cur;
            }else{
                set.add(cur);
            }
            cur = cur.next;
        }
        return null;
    }
}
