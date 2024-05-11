class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long ans = 0;
        for(int end = n - 1; end > n - k - 1; end--){
            int happinessDeducted = n - 1 - end;
            if(happiness[end] - happinessDeducted <= 0){
                break;
            }
            ans += (happiness[end] - happinessDeducted);
        }
        return ans;
    }
}