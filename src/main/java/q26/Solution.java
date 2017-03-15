package q26;

import java.util.ArrayList;

/**
 * Created by leibro on 2017/3/15.
 */
public class Solution {
/*    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        return findPath(root,0,target);
    }

    private ArrayList<ArrayList<Integer>> findPath(TreeNode node,int count,int target) {
        if(node == null) {
            return new ArrayList<ArrayList<Integer>>();
        }
        if(count + node.val == target) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            ArrayList<Integer> path = new ArrayList<>();
            path.add(node.val);
            res.add(path);
            return res;
        }
        ArrayList<ArrayList<Integer>> leftPath = findPath(node.left,count + node.val,target);
        ArrayList<ArrayList<Integer>> rightPath = findPath(node.right,count + node.val,target);
        ArrayList<ArrayList<Integer>> sumPath = new ArrayList<>();
        if(!leftPath.isEmpty()) {
            for(ArrayList<Integer> path:leftPath) {
                path.add(node.val);
                sumPath.add(path);
            }
        }
        if(!rightPath.isEmpty()) {
            for(ArrayList<Integer> path:rightPath) {
                path.add(node.val);
                sumPath.add(path);
            }
        }
        return sumPath;
    }*/

    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        findPath(root,target);
        return res;
    }

    private void findPath(TreeNode root,int target) {
        if(root == null)
            return;
        path.add(root.val);
        if(target - root.val == 0 && root.left == null && root.right == null)
            res.add(new ArrayList<>(path));
        FindPath(root.left,target - root.val);
        FindPath(root.right,target - root.val);
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(10);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(12);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(7);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        ArrayList<ArrayList<Integer>> res = new Solution().FindPath(treeNode1,22);
    }
}
