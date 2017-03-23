package q58;

import q57.ListNode;

import java.util.List;

/**
 * Created by leibro on 2017/3/22.
 */
public class Solution {
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode fakeHead = new ListNode(-1);
        ListNode pre = fakeHead;
        ListNode p = pHead;
        while(p != null) {
            if(p.next == null)
                break;
            else if(p.val != p.next.val) {
                pre.next = p;
                pre = p;
                p = p.next;
            } else if(p.val == p.next.val) {
                while(p != null && p.next != null && p.val == p.next.val) {
                    p = p.next;
                }
                if(p == null || p.next == null) {
                    pre.next = null;
                } else {
                    pre.next = p.next;
                    p = p.next;
                }

            }
        }
        return fakeHead.next;

    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        new Solution().deleteDuplication(listNode1);
    }
}
