/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int idx = 0;
    public TreeNode ConstructTree(int[] preorder, int[] inorder, int start, int end){  
        if (start>end)
            return null;
        int curr = preorder[idx];
        idx++;
        TreeNode node = new TreeNode(curr);
        if (start==end)
            return node;
        int pos = search(inorder,start,end,curr);
        node.left=ConstructTree(preorder,inorder,start,pos-1);
        node.right=ConstructTree(preorder,inorder,pos+1,end);
        return node;
    }
    public int search(int[] inorder,int start, int end, int value){
        for(int i=start;i<=end;i++){
            if (inorder[i]==value)
                return i;
        }
        return -1;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return ConstructTree(preorder,inorder,0,(inorder.length)-1);
    }
}