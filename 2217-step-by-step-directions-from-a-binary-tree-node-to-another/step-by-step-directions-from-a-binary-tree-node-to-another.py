class Solution:
    def getDirections(self, root: Optional[TreeNode], startValue: int, destValue: int) -> str:
        # Helper function to find the path to the given target value
        def findPath(root, val):
            if root is None:
                return None
            if root.val == val:
                return ""
            left = findPath(root.left, val)
            right = findPath(root.right, val)
            if left is not None:
                return 'L' + left
            if right is not None:
                return 'R' + right
            return None

        # Helper function to find the lowest common ancestor
        def findLCA(root, p, q):
            if root is None or root.val == p or root.val == q:
                return root
            left = findLCA(root.left, p, q)
            right = findLCA(root.right, p, q)
            return root if left and right else left or right

        lca = findLCA(root, startValue, destValue)
        pathToStart = findPath(lca, startValue)
        pathToDest = findPath(lca, destValue)
        return 'U' * len(pathToStart) + pathToDest