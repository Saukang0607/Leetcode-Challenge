class Solution {
    int ans = 0;    // 最短用时
    int depth = -1; // 起始节点的高度
    
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, 0, start);
        return ans;
    }
    
    int dfs(TreeNode root, int level, int start) {
        if (root == null) return 0;
        if (root.val == start) depth = level;                       // 当前节点即起始节点
        int l = dfs(root.left, level + 1, start);                   // 左子树的树高
        boolean inLeft = depth != -1;                               // 起始节点是否在左子树上
        int r = dfs(root.right, level + 1, start);                  // 右子树的树高
        if (root.val == start) ans = Math.max(ans, Math.max(l, r)); // 情况1：感染以 start 为根结点的树所需时间
        if (inLeft) ans = Math.max(ans, depth - level + r);         // 情况2：感染以 root 为根结点的树所需时间
        else ans = Math.max(ans, depth - level + l);
        return Math.max(l, r) + 1;                                  // 返回树高
    }
}
