package q38;

/**
 * Created by leibro on 2017/3/17.
 */
public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null)
            return null;
        int len1 = count(pHead1);
        int len2 = count(pHead2);
        if(len1 > len2) {
            return search(pHead1,pHead2,len1,len2);
        } else {
            return search(pHead2,pHead1,len2,len1);
        }
    }

    public ListNode search(ListNode node1,ListNode node2,int len1,int len2) {
        int len = len1 - len2;
        for(int i = 0;i < len;i ++) {
            node1 = node1.next;
        }
        return firstEqual(node1,node2);

    }

    public ListNode firstEqual(ListNode node1,ListNode node2) {
        while(node1 != null && node2 != null) {
            if(node1.val == node2.val && node1.next == node2.next)
                return node1;
            else {
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return null;
    }

    public int count(ListNode node) {
        int count = 0;
        while(node != null) {
            count ++;
            node = node.next;
        }
        return count;
    }
}
