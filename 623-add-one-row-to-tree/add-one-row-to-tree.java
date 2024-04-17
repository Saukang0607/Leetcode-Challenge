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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(depth == 1) return new TreeNode(val, root, null);
        deque.addLast(root);

        int currentDepth = 1;
        while(!deque.isEmpty()){
            int size = deque.size();
            while(size-- > 0){ //当层还有节点
                TreeNode currentNode = deque.removeFirst();
                if(currentDepth == depth - 1){
                    TreeNode a = new TreeNode(val), b = new TreeNode(val);
                    a.left = currentNode.left; b.right = currentNode.right;
                    currentNode.left = a; currentNode.right = b;
                }
                else{
                    if(currentNode.left != null )deque.add(currentNode.left);
                    if(currentNode.right != null) deque.add(currentNode.right);
                }
            }
            currentDepth++;
        }

        return root;
    }
}