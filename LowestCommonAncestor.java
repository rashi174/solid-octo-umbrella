/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //if looking for me return me :P
        if (root == p || root == q)
        {
            return root;
        }
        TreeNode left = null;
        TreeNode right = null;
        //search in left part
        if (root.left!=null){
            left = lowestCommonAncestor(root.left,p,q);
        }
         //search in right part
        if (root.right!=null){
            right = lowestCommonAncestor(root.right,p,q);
        }
        //if both returned node then root is ancestor
        if(left!=null && right!=null) return root;
        //otherwise whichever is not null
        if(left==null) return right;
        return left;
    }
}