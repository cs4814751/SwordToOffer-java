package q66;

/**
 * Created by leibro on 2017/3/23.
 */
public class Solution {
    private int count;
    TreeNode KthNode(TreeNode pRoot, int k)
    {
        count = 0;
        return inOrder(pRoot,k);
    }

    TreeNode inOrder(TreeNode node,int k) {
        if(node == null)
            return null;
        TreeNode target = inOrder(node.left,k);
        if(target != null)
            return target;
        count ++;
        if(count == k)
            return node;
        target = inOrder(node.right,k);
        if(target != null)
            return target;
        return null;
    }
}
