class Solution {
  public String[] findRelativeRanks(int[] score) {
    int n = score.length;
    String[] top3 = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    int[] ranked = score.clone();
    Arrays.sort(ranked);
    Map<Integer, Integer> hashMap = new HashMap<>();
    for(int i = n; i > 0 ; i--){
        hashMap.put(ranked[n-i], i); //each player's score: rank
        //eg: first player is with lowest score, so his rank is n
    }
    String[] ans = new String[n];
    for(int i = 0; i < n ; i++){
        int rank = hashMap.get(score[i]);
        ans[i] = rank <= 3 ? top3[rank-1] : (rank + "");
    }
    return ans;
  }
}
