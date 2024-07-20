class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] matrix = new int[rowSum.length][colSum.length];
        for(int i = 0; i < rowSum.length; i++){
            for(int j = 0; j < colSum.length; j++){
                matrix[i][j] = Math.min(rowSum[i], colSum[j]); //greedy: fit the smallest sum
                rowSum[i] -= matrix[i][j]; //remaining count for other row
                colSum[j] -= matrix[i][j];
            }
        }
        return matrix;
    }
}