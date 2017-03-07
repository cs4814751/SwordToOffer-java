package q17;

/**
 * Created by leibro on 2017/3/8.
 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode pre = head;
        ListNode next = head.next;
        head.next = null;
        while(next != null) {
            ListNode p = next.next;
            next.next = pre;
            pre = next;
            next = p;
        }
        return pre;
    }
}
