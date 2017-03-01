package q6;

/**
 * Created by leibro on 2017/3/1.
 */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = construct(pre,0,pre.length - 1,in,0,in.length - 1);
        return root;
    }

    private TreeNode construct(int[] pre,int preHead,int preTail,int[] in,int inHead,int inTail) {
        TreeNode root = new TreeNode(pre[preHead]);
        int rootAtIn = -1;
        for(int i = inHead;i <= inTail;i ++) {
            if(in[i] == root.val) {
                rootAtIn = i;
                break;
            }
        }
        int rootInLeft = rootAtIn - inHead;
        int rootInRight = inTail - rootAtIn;
        if(rootInLeft > 0)
            root.left = construct(pre,preHead + 1,preHead + rootInLeft,in,inHead,inHead + rootInLeft - 1);
        if(rootInRight > 0)
            root.right = construct(pre,preHead + rootInLeft + 1,preTail,in,rootAtIn + 1,inTail);
        return root;
    }
}
