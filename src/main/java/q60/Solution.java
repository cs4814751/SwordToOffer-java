package q60;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leibro on 2017/3/22.
 */
public class Solution {
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null)
            return true;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        preOrder(pRoot,list1);
        preOrderSymmetrical(pRoot,list2);
        for(int i = 0;i < list1.size();i ++) {
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }

    private void preOrder(TreeNode node,List<Integer> list) {
        if(node == null) {
            list.add((int)'#');
            return;
        }
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }

    private void preOrderSymmetrical(TreeNode node,List<Integer> list) {
        if(node == null) {
            list.add((int)'#');
            return;
        }
        list.add(node.val);
        preOrderSymmetrical(node.right,list);
        preOrderSymmetrical(node.left,list);
    }
}
