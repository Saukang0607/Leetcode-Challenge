# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def leafSimilar(self, root1: Optional[TreeNode], root2: Optional[TreeNode]) -> bool:
        
        ans1 = []
        ans2 = []

        self.stack(root1, ans1)
        self.stack(root2, ans2)
        
        return ans1 == ans2
    
    def stack(self, node: Optional[TreeNode], ans: List[int]):
        if node is None:
            return

        if node.left is None and node.right is None:
            ans.append(node.val)
            return
        
        self.stack(node.left, ans)
        self.stack(node.right, ans)

        
