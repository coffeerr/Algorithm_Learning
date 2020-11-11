package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/11 9:42 上午
 */

public class LC23 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0, null);
        ListNode node = l3;
        while (l1 != null && l2 != null) {
            l3.next = l1.val < l2.val ? l1 : l2;
            if (l1.val < l2.val) {
                l1 = l1.next;

            } else {
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        while (l1 != null || l2 != null) {
            l3.next = l1 == null ? l2 : l1;
            if (l1 != null) {
                l1 = l1.next;
            } else {
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        return node.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) return lists[0];
        if (lists.length == 0 || lists==null) return null;
        ListNode l3 = mergeTwoLists(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            l3 = mergeTwoLists(l3,lists[i]);
        }
        return l3;
    }
}
