package LeetCode;

/**
 * @description:
 * @author: Desmand
 * @time: 2021/1/3 8:38 上午
 */

public class LC86 {
    public ListNode partition(ListNode head, int x) {
        ListNode curNode = head,curNode2 = head;
        ListNode h2 = new ListNode(0);
        ListNode curAnsNode = h2;
        boolean isHead = true,isTail = true;
        while (curNode != null) {
            if (curNode.val < x) {
                isHead = false;
                curAnsNode.next = new ListNode(curNode.val);
                curAnsNode = curAnsNode.next;
            }
            curNode = curNode.next;
        }
        if(isHead){
            ListNode temp = new ListNode(x);
            temp.next = head;
            return temp;
        }
        while (head != null) {
            if (head.val >= x) {
                isTail = false;
                curAnsNode.next = new ListNode(head.val);
                curAnsNode = curAnsNode.next;
            }
            head = head.next;
        }
        if(isTail){
            head = new ListNode(x);
            return curNode2;
        }
        return h2.next;
    }
}
