class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        int[] modulusCount = new int[k];
        modulusCount[0] = 1;
        int ans = 0;
        prefixSum[0] = 0;
        prefixSum[1] = nums[0];
        for(int i = 2; i < nums.length + 1; i++){
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        for(int i = 0; i < nums.length; i++){
            int modulus = (prefixSum[i+1] % k + k) % k;
            ans += modulusCount[modulus];
            modulusCount[modulus]++;
        }
        
        return ans;
    }
}