class Solution {
    private static final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private int m, n;
    public int getMaximumGold(int[][] grid_) {
        grid = grid_;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i++) 
            for(int j = 0; j < n; j++)
                ans = Math.max(ans, dfs(i, j));
        return ans;
    }

    private int dfs(int x, int y){
        if(x < 0 || y < 0 || x == m || y == n || grid[x][y] == 0)
            return 0;
        int cur = grid[x][y], max = 0;
        grid[x][y] = 0;
        for(int[] dir: DIRS)
            max = Math.max(max, dfs(x + dir[0], y + dir[1]));
        grid[x][y] = cur;
        return cur + max;
    }
}

