package q20;

/**
 * Created by leibro on 2017/3/14.
 */
public class Solution {
    public void Mirror(TreeNode root) {
        if(root == null)
            return;
        swapChildNode(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swapChildNode(TreeNode root) {
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;
    }


}
