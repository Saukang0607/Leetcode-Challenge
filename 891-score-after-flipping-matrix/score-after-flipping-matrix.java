class Solution {
    public int matrixScore(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) flipRow(grid[i]);
        }

        for (int j = 1; j < grid[0].length; j++) {
            int oneCount = 0;
            int zeroCount = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 0) zeroCount++;
                else oneCount++;
            }
            if(zeroCount > oneCount){
                flipColumn(grid, j);
            }
        }

        int score = 0;
        for (int i = 0; i < grid.length; i++) {
            int rowValue = grid[i][0] == 1 ? (1 << (grid[0].length - 1)) : 0; // Most significant bit
            for (int j = 1; j < grid[0].length; j++) {
                rowValue += grid[i][j] * Math.pow(2, grid[0].length - j - 1);
            }
            score += rowValue;
        }
        return score;
    }

    public void flipRow(int[] row) {
        for (int j = 0; j < row.length; j++) {
            if (row[j] == 1) row[j] = 0;
            else row[j] = 1;
        }
    }

    public void flipColumn(int[][] grid, int k){
        for (int j = 0; j < grid.length; j++) {
            if (grid[j][k] == 1) grid[j][k] = 0;
            else grid[j][k] = 1;
        }
    }
}