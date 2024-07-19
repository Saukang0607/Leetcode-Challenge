class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int max_list[] = new int[matrix[0].length]; //maximunm in column
        int min_list[] = new int[matrix.length]; //minimum in row

        for(int i = 0; i < matrix.length; i++){ 
            min_list[i] = Integer.MAX_VALUE;
            for(int j = 0; j < matrix[0].length; j++){ 
                min_list[i] = Math.min(matrix[i][j], min_list[i]);
                max_list[j] = Math.max(matrix[i][j], max_list[j]);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){ 
            for(int j = 0; j < matrix[0].length; j++){ 
                if(min_list[i] == max_list[j] && min_list[i] == matrix[i][j]) ans.add(matrix[i][j]);
            }
        }
        return ans;
    }
}