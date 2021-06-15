'''
113. Path Sum II

Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
A leaf is a node with no children. 

Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: []
Example 3:

Input: root = [1,2], targetSum = 0
Output: []
 

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000

'''

class Solution:
    def __init__(self):
        self.AllPaths=[]
        
    def pathSum(self, root: TreeNode, targetSum: int) -> List[List[int]]:
        self.path(root,targetSum,[],0)
        return self.AllPaths
    
    def path(self,root,target,currentPath,s):
        if root:
            if s+root.val==target and (root.left == None and root.right == None):
                currentPath.append(root.val)
                self.AllPaths.append(currentPath)
            else:
                s+=root.val
                currentPath.append(root.val)
                self.path(root.left,target,currentPath[:],s)
                self.path(root.right,target,currentPath[:],s)
