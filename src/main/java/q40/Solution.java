package q40;

/**
 * Created by leibro on 2017/3/17.
 */
public class Solution {
    private int depth = 0;
    private int now = 0;

    public int TreeDepth(TreeNode root) {
        if(root == null)
            return 0;
        visit(root);
        return depth;
    }

    private void visit(TreeNode node) {
        if(node == null)
            return;
        now ++;
        if(now > depth)
            depth = now;
        TreeDepth(node.left);
        TreeDepth(node.right);
        now --;
    }
}
