package q27;

/**
 * Created by leibro on 2017/3/15.
 */
public class Solution {
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead == null)
            return null;
        cloneAfterNode(pHead);
        connectRandomNode(pHead);
        return splitRandomList(pHead);
    }

    private void cloneAfterNode(RandomListNode node) {
        while(node != null) {
            RandomListNode next = node.next;
            RandomListNode cloneNode = new RandomListNode(node.label);
            node.next = cloneNode;
            cloneNode.next = next;
            node = next;
        }
    }

    private void connectRandomNode(RandomListNode node) {
        RandomListNode cloneNode;
        while(node != null) {
            cloneNode = node.next;
            if(node.random == null) {
                cloneNode.random = null;
            } else {
                cloneNode.random = node.random.next;
            }
            node = cloneNode.next;
        }
    }

    private RandomListNode splitRandomList(RandomListNode node) {
        RandomListNode head = new RandomListNode(Integer.MIN_VALUE);
        RandomListNode pre = head;
        while(node != null) {
            pre.next = node.next;
            pre = node.next;
            node.next = node.next.next;
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        node1.next = node2;
        node2.next = node3;
        node1.random = node3;
        node3.random = node1;
        RandomListNode res = new Solution().Clone(node1);
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
