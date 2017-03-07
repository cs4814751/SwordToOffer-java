package q18;

/**
 * Created by leibro on 2017/3/8.
 */
public class Solution {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode res = new ListNode(0);
        ListNode fakeHead = res;
        while(head1 != null || head2 != null) {
            if(head1 != null && head2 != null) {
                if(head1.val <= head2.val) {
                    res.next = head1;
                    head1 = head1.next;
                    res = res.next;
                } else {
                    res.next = head2;
                    head2 = head2.next;
                    res = res.next;
                }
            } else if(head1 == null && head2 != null) {
                while(head2 != null) {
                    res.next = head2;
                    head2 = head2.next;
                    res = res.next;
                }
            } else {
                while(head1 != null) {
                    res.next = head1;
                    head1 = head1.next;
                    res = res.next;
                }
            }
        }
        return fakeHead.next;
    }
}
