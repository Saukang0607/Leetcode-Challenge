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
    int sumValue = 0;
    public TreeNode bstToGst(TreeNode root) {
        dfsRight(root.right);
        sumValue += root.val;
        root.val = sumValue;
        dfsRight(root.left);
        return root;
    }

    public void dfsRight(TreeNode curr){
        if(curr == null){
            return;
        }

        dfsRight(curr.right);
        sumValue += curr.val;
        curr.val = sumValue;
        dfsRight(curr.left);
    }
}