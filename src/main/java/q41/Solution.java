package q41;

/**
 * Created by leibro on 2017/3/17.
 */
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        return visit(root);
    }

    private boolean visit(TreeNode node) {
        boolean res = true;
        if(node == null)
            return true;
        if(visit(node.left))
            if(visit(node.right))
                res = true;
            else
                res = false;
        else
            res = false;
        int left_depth = Depthor.depth(node.left);
        int right_depth = Depthor.depth(node.right);
        if(left_depth == right_depth || Math.abs(left_depth - right_depth) <= 1)
            res = true;
        else
            res = false;
        return res;
    }

    private static class Depthor {
        private static int now;
        private static int depth;

        static int depth(TreeNode root) {
            now = 0;
            depth = 0;
            if(root == null)
                return 0;
            visit(root);
            return depth;
        }

        private static void visit(TreeNode node) {
            if(node == null)
                return;
            now ++;
            if(now > depth)
                depth = now;
            visit(node.left);
            visit(node.right);
            now --;
        }
    }
}
