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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0; // Base case: empty tree has diameter 0
        }
        
        depth(root);
        return max; // Since the depth function already includes the root node, subtract 2
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0; // Base case: empty tree has height 0
        }

        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);
        
        max = Math.max(max, leftHeight + rightHeight);

        return Math.max(leftHeight + 1, rightHeight + 1) ; // Add 1 for the current node
    }
}
