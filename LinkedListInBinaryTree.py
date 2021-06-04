# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.AllPaths=[]
    def isSubPath(self, head: ListNode, root: TreeNode) -> bool:
        self.Paths(root,'')
        llist = ''
        while head:
            llist+=str(head.val)
            head=head.next
        for path in self.AllPaths:
            if llist in path:
                return True
        return False
    def Paths(self,root,path):
        if root:
            path+=str(root.val)
            self.Paths(root.left,path)
            self.Paths(root.right,path)
            if root.left == None and root.right == None:
                self.AllPaths.append(path)
                
        
            
