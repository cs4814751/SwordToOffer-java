package q7;

import java.util.ArrayList;

/**
 * Created by leibro on 2017/3/2.
 */

/*
实现两个队列模拟一个栈
 */
public class Solution2 {
    private ArrayList<Integer> list1 = new ArrayList<>();
    private ArrayList<Integer> list2 = new ArrayList<>();

    public void push(int e) {
        while(!list2.isEmpty()) {
            list1.add(list2.remove(0));
        }
        while(!list1.isEmpty()) {
            list2.add(list1.remove(0));
        }
        list1.add(e);
    }

    public int pop() {
        int r = list1.remove(0);
        if(!list2.isEmpty()) {
            list1.add(list2.remove(0));
        }
        return r;
    }

    public static void main(String[] args) {
        Solution2 stack = new Solution2();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }


}
