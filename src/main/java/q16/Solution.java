package q16;
/**
 * Created by leibro on 2017/3/7.
 */
public class Solution {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null)
            return null;
        if(k <= 0)
            return null;
        ListNode p1 = head;
        ListNode p2 = head;
        for(int i = 1;i < k;i ++) {
            p2 = p2.next;
            if(p2 == null)
                return null;
        }
        while(p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }
}
