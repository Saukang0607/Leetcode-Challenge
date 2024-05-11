class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long ans = 0;
        for(int end = n - 1; end > (n - 1) - k; end--){ //
            int happinessDeducted = n - 1 - end; //see variable name to understand
            if(happiness[end] - happinessDeducted <= 0){
                break;
            }
            ans += (happiness[end] - happinessDeducted);
        }
        return ans;
    }
}