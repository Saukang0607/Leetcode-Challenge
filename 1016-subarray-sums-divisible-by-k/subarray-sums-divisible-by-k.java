class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] modulusCount = new int[k]; //hashmap (modulus : count)
        modulusCount[0] = 1; //need this

        int ans = 0, sum = 0;

        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            int modulus = (sum % k + k) % k;
            ans += modulusCount[modulus];
            modulusCount[modulus]++;
        }
        
        return ans;
    }
}