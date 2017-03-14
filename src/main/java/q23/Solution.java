package q23;

import java.util.Stack;

/**
 * Created by leibro on 2017/3/14.
 */
public class Solution {
    private Stack<Integer> helper = new Stack<>();
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean ordered = true;
        int p1 = 0;
        int p2 = 0;
        while(p2 < popA.length) {
            if(helper.empty())
                helper.push(pushA[p1 ++]);
            while(helper.peek() != popA[p2]) {
                if(p1 == pushA.length) {
                    ordered = false;
                    break;
                }
                helper.push(pushA[p1 ++]);
            }
            if(!ordered)
                break;
            helper.pop();
            p2 ++;
        }
        return ordered;
    }
}
