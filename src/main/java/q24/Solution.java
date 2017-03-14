package q24;

import java.util.ArrayList;

/**
 * Created by leibro on 2017/3/14.
 */
public class Solution {
    private ArrayList<TreeNode> nodes = new ArrayList<>();
    private ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if(root == null)
            return res;
        bfs(root);
        return res;

    }

    private void bfs(TreeNode root) {
        nodes.add(root);
        while(!nodes.isEmpty()) {
            TreeNode node = nodes.remove(0);
            res.add(node.val);
            if(node.left != null)
                nodes.add(node.left);
            if(node.right != null)
                nodes.add(node.right);
        }
    }
}
