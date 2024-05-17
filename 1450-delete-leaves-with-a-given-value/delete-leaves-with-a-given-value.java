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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode dummy = new TreeNode(0, root, null);

        dummy.left = dfs(dummy.left, target);
        dummy.right = dfs(dummy.right, target);

        return dummy.left;
    }

    public TreeNode dfs(TreeNode curr, int target){
        if(curr == null){
            return null;
        }
        
        curr.left = dfs(curr.left, target);
        curr.right = dfs(curr.right, target);

        if(curr.val == target && curr.left == null && curr.right == null){
            return null;
        }   

        return curr;
    }
}