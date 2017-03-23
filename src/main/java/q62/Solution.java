package q62;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leibro on 2017/3/23.
 */
public class Solution {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(pRoot == null)
            return res;
        List<TreeNode> queue1 = new ArrayList<>();
        List<TreeNode> queue2 = new ArrayList<>();
        queue1.add(pRoot);
        int level = 1;
        while(queue1.size() > 0 || queue2.size() > 0) {
            ArrayList<Integer> bucket = new ArrayList<>();
            if(level % 2 == 1) {
                while(queue1.size() > 0) {
                    TreeNode node = queue1.remove(0);
                    bucket.add(node.val);
                    if(node.left != null)
                        queue2.add(node.left);
                    if(node.right != null)
                        queue2.add(node.right);
                }
            } else {
                while(queue2.size() > 0) {
                    TreeNode node = queue2.remove(0);
                    bucket.add(node.val);
                    if(node.left != null)
                        queue1.add(node.left);
                    if(node.right != null)
                        queue1.add(node.right);
                }
            }
            res.add(bucket);
            level ++;
        }
        return res;
    }
}
