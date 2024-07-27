class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] w = new int[n][n]; //total weights from city i to city j
        for(int[] row : w){
            Arrays.fill(row, 10001); //since weighti, distanceThreshold <= 10^4
        }

        for(int[] edge : edges){
            int x = edge[0], y = edge[1], weight = edge[2];
            w[x][y] = w[y][x] = weight;
        }

        int[][][] memo = new int[n][n][n]; //for memoization search
        int ans = 0;
        int min_count = n - 1; 

        for(int i = 0; i < n; i++){
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(i != j && dfs(n-1, i, j, memo, w) <= distanceThreshold){
                    cnt++;
                }
            }
            
            if(cnt <= min_count){ //return city with greatest number 
                min_count = cnt;
                ans =  i;
            }
        }

        return ans;
    }

    private int dfs(int k, int i, int j, int[][][] memo, int[][]w){
        if(k < 0) return w[i][j]; //base case
        if(memo[k][i][j] != 0) return memo[k][i][j];
        return memo[k][i][j] = Math.min(dfs(k-1, i, j, memo, w), dfs(k-1, i, k, memo, w) + dfs(k-1, k, j, memo, w));
        //state transition equation: indicates minimum weights path from city i to city j, with intermediate city's number less than k
    }
}