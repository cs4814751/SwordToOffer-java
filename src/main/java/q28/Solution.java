package q28;

/**
 * Created by leibro on 2017/3/15.
 */
public class Solution {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null)
            return null;
        TreeNode head = findFirstNode(pRootOfTree);
        convert(pRootOfTree);
        return head;
    }

    private void convert(TreeNode root) {
        TreeNode left = visitLeftTree(root.left);
        if(left != null)
            left.right = root;
        root.left = left;
        TreeNode right = visitRightTree(root.right);
        if(right != null)
            right.left = root;
        root.right = right;
    }

    private TreeNode findFirstNode(TreeNode node) {
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    private TreeNode visitLeftTree(TreeNode node) {
        if(node == null)
            return null;
        TreeNode left = visitLeftTree(node.left);
        if(left != null)
            left.right = node;
        node.left = left;
        TreeNode right = visitRightTree(node.right);
        if(right != null)
            right.left = node;
        node.right = right;
        if(right == null)
            return node;
        else
            return right;
    }

    private TreeNode visitRightTree(TreeNode node) {
        if(node == null)
            return null;
        TreeNode left = visitLeftTree(node.left);
        if(left != null)
            left.right = node;
        TreeNode right = visitRightTree(node.right);
        if(right != null)
            right.left = node;
        node.right = right;
        if(left == null)
            return node;
        else
            return left;
    }


    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(14);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(12);
        TreeNode treeNode7 = new TreeNode(16);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        new Solution().Convert(treeNode1);
    }
}
