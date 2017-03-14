package q22;

import java.util.Stack;

/**
 * Created by leibro on 2017/3/14.
 */
public class Solution {
    Stack<Integer> main = new Stack<>();
    Stack<Integer> helper = new Stack<>();

    public void push(int node) {
        if(helper.empty()) {
            main.push(node);
            helper.push(node);
        } else {
            main.push(node);
            if(node >= helper.peek()) {
                helper.push(helper.peek());
            } else {
                helper.push(node);
            }
        }
    }

    public void pop() {
        helper.pop();
        main.pop();
    }

    public int top() {
        return main.peek();
    }

    public int min() {
        return helper.peek();
    }
}
