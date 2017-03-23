package q63;

/**
 * Created by leibro on 2017/3/22.
 */
public class Solution {
    private int index = -1;

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Serialize(root,sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void Serialize(TreeNode node,StringBuilder sb) {
        if(node == null) {
            sb.append("$,");
            return;
        }
        sb.append(node.val + ",");
        Serialize(node.left,sb);
        Serialize(node.right,sb);
    }

    TreeNode Deserialize(String str) {
        String[] strs = str.split(",");
        index = -1;
        return Deserialize(strs);
    }

    private TreeNode Deserialize(String[] str) {
        index ++;
        if(str[index] == "$")
            return null;
        int val = Integer.parseInt(str[index]);
        TreeNode node = new TreeNode(val);
        node.left = Deserialize(str);
        node.right = Deserialize(str);
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;
        String s = new Solution().Serialize(treeNode1);
    }
}
