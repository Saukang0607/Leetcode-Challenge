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
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        boolean isEvenLevel = true;
        d.addLast(root);
        while(!d.isEmpty()){
            int size = d.size(), prev = isEvenLevel ? 0 : Integer.MAX_VALUE;
            while(size > 0){
                size -= 1;
                TreeNode cur = d.pollFirst();
                if(isEvenLevel && (cur.val % 2 == 0 || cur.val <= prev)) return false;
                if(!isEvenLevel && (cur.val % 2 != 0 || cur.val >= prev)) return false;
                prev = cur.val;
                if(cur.left != null) d.addLast(cur.left);
                if(cur.right != null) d.addLast(cur.right);
            }
            isEvenLevel = !isEvenLevel;
        }
        return true;
    }
}