package q19;

/**
 * Created by leibro on 2017/3/13.
 */
public class Solution {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null) {
            if(root1.val == root2.val)
                result = equalTree(root1,root2);
            if(!result)
                result = HasSubtree(root1.left,root2);
            if(!result)
                result = HasSubtree(root1.right,root2);
        }
        return result;
    }

    public boolean equalTree(TreeNode root1,TreeNode root2) {
        if(root1 == null && root2 == null)
            return true;
        else if(root1 != null && root2 == null)
            return true;
        else if(root1 == null && root2 != null)
            return false;
        boolean result = false;
        if(root1.val == root2.val) {
            result = equalTree(root1.left,root2.left);
            if(result) {
                result = equalTree(root1.right,root2.right);
            }
        }
        return result;
    }
}
