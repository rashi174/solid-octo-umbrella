# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isBalanced(self, root: TreeNode) -> bool:
        if root==None:
            return True
        lh=self.height(root.left)
        rh=self.height(root.right)
        return abs(lh-rh)<2 and self.isBalanced(root.left) and self.isBalanced(root.right)
    def height(self,root):
        if root==None:
            return True
        left = self.height(root.left)
        right = self.height(root.right)
        return 1+max(left,right)