package q5;

/**
 * Created by leibro on 2017/3/1.
 */
import java.util.ArrayList;


public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        printChild(list,listNode);
        return list;

    }

    private void printChild(ArrayList<Integer> list,ListNode listNode) {
        if(listNode == null)
            return;
        printChild(list,listNode.next);
        list.add(listNode.val);
    }
}
