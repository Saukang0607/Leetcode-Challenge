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
    int d, v; //ensure val and depth is visible
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        d = depth; v = val;
        if(depth == 1) return new TreeNode(val, root, null); //edge case: only one layer
        int cur = 1;
        dfs(root, cur);
        return root;
    }

    void dfs(TreeNode root, int currentDepth){ 
        if(root == null){ //reach leaf
            return;
        }
        if(currentDepth == d - 1){
            TreeNode a = new TreeNode(v); TreeNode b = new TreeNode(v);
            a.left = root.left; b.right = root.right;
            root.left = a; root.right = b;
        }
        else{
            dfs(root.left, currentDepth + 1);
            dfs(root.right, currentDepth + 1);
        }
    }   
}