class Solution {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> ans = new ArrayList<>();
        for(int i = 0 ; i < land.length; i++){
            for(int j = 0; j <land[0].length; j++){
                if(land[i][j] == 0 || i > 0 && land[i-1][j] == 1 || j > 0 && land[i][j-1] == 1){ //if not top left corner will skipp
                    continue;
                }

                int endRow = i;//dont add first to pass one hectre edge case
                while(endRow + 1 < land.length && land[endRow + 1][j] == 1){
                    endRow++;
                }

                int endColumn = j;
                while(endColumn + 1 < land[0].length && land[i][endColumn + 1] == 1){
                    endColumn++;
                }

                ans.add(new int[]{i,j,endRow,endColumn});
            }
        }

        return ans.toArray(new int[0][]); 
    }
}