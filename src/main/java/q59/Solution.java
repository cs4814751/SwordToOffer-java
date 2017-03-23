package q59;

/**
 * Created by leibro on 2017/3/22.
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode == null)
            return null;
        if(pNode.right != null) {
            return getLeftChild(pNode.right);
        } else {
            return getParentRight(pNode);
        }
    }

    private TreeLinkNode getLeftChild(TreeLinkNode node) {
        if(node.left == null)
            return node;
        else
            return getLeftChild(node.left);
    }

    private TreeLinkNode getParentRight(TreeLinkNode node) {
        TreeLinkNode p = node;
        TreeLinkNode parent = p.next;
        while(parent != null) {
            if(parent.left == p)
                return parent;
            else {
                p = parent;
                parent = parent.next;
            }
        }
        return null;
    }
}
