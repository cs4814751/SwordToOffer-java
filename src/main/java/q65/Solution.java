package q65;

/**
 * Created by leibro on 2017/3/22.
 */
import java.util.*;
public class Solution {
    LinkedList<Integer> deque = new LinkedList<>();

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        int w = size;
        ArrayList<Integer> res = new ArrayList<>();
        if(w == 0)
            return res;
        for(int i = 0;i < num.length;i ++) {
            if(deque.size() == 0)
                deque.addLast(i);
            while(deque.size() > 0 && num[deque.peekLast()] < num[i])
                deque.removeLast();
            deque.addLast(i);
            if(i < w - 1)
                continue;
            while(deque.peekFirst() < i - w + 1)
                deque.removeFirst();
            res.add(num[deque.peekFirst()]);
        }
        return res;
    }
}
