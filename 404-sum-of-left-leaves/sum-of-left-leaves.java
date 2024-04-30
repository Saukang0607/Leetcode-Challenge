/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int ans = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        if(root.left == null && root.right == null) return 0; //edge case

        TreeNode dummy = new TreeNode(0, root, null); // root neither stay at left or right, hence this
        recursiveCheck(dummy.left, true);
        return ans;
    }

    public void recursiveCheck(TreeNode root, boolean isLeft) {
        if (root == null)
            return; // base case

        if (root.left == null && root.right == null && isLeft) {
            ans += root.val;
            return;
        }

        recursiveCheck(root.left, true);
        recursiveCheck(root.right, false);
    }
}