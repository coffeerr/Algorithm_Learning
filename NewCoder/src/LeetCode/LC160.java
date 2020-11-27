package LeetCode;

import java.util.HashMap;

/**
 * @description: 相交链表
 * @author: Desmand
 * @time: 2020/11/27 9:38 上午
 */

public class LC160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        HashMap<ListNode, Integer> map = new HashMap<>();
//        while (headA != null) {
//            map.put(headA, headA.val);
//            headA = headA.next;
//        }
//        while (headB != null) {
//            if (map.get(headB) != null && map.get(headB) != 0) {
//                return headB;
//            }
//            headB = headB.next;
//        }
//        return null;
        //双指针法，这道题两个链表有一个公共路段
        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            ha = ha == null ? headB : ha.next;
            hb = hb == null ? headA : hb.next;
        }
        return ha;

    }
}
