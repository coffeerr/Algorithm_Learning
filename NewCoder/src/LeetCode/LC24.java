package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/2/14 10:33 上午
 */

public class LC24 {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1,head);
        recursive(dummyHead);
        return dummyHead.next;
    }
    void recursive(ListNode root){
        if(root.next!=null && root.next.next!=null){
            ListNode a = root.next,b = root.next.next;
            root.next = b;
            a.next = b.next;
            b.next = a;
            recursive(a);
        }
    }
}
