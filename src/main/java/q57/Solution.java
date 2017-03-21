package q57;

/**
 * Created by leibro on 2017/3/21.
 */
public class Solution {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if(pHead == null)
            return null;
        ListNode meetNode = findMeeting(pHead);
        if(meetNode == null)
            return null;
        int loopCount = 1;
        ListNode p = meetNode.next;
        while(p != meetNode) {
            loopCount ++;
            p = p.next;
        }
        ListNode slow = pHead;
        ListNode fast = pHead;
        for(int i = 0;i < loopCount;i ++) {
            fast = fast.next;
        }
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private ListNode findMeeting(ListNode pHead) {
        ListNode p_slow = pHead.next;
        if(p_slow == null)
            return null;
        ListNode p_fast = p_slow.next;
        while(p_slow != null && p_fast != null) {
            if(p_slow == p_fast)
                return p_slow;
            p_slow = p_slow.next;

            p_fast = p_fast.next;
            if(p_fast == null)
                return null;
            p_fast = p_fast.next;
        }
        return null;
    }
}
