package q61;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by leibro on 2017/3/22.
 */

/*之字型打印 两个stack 奇偶层各用一个 对称遍历*/
public class Solution {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if(pRoot == null)
            return new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(pRoot);
        int level = 1;
        while(stack1.size() > 0 || stack2.size() > 0) {
            ArrayList<Integer> bucket = new ArrayList<>();
            if(level % 2 == 0) {
                while(stack2.size() > 0) {
                    TreeNode node = stack2.pop();
                    bucket.add(node.val);
                    if(node.right != null)
                        stack1.push(node.right);
                    if(node.left != null)
                        stack1.push(node.left);
                }
            } else {
                while(stack1.size() > 0) {
                    TreeNode node = stack1.pop();
                    bucket.add(node.val);
                    if(node.left != null)
                        stack2.push(node.left);
                    if(node.right != null)
                        stack2.push(node.right);
                }
            }
            res.add(bucket);
            level ++;
        }
        return res;


    }
}
