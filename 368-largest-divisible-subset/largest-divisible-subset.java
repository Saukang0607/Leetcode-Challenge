class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n]; //len of subset until nums[i]
        int[] g = new int[n]; //record the second last element of subset f[i]
        for(int i = 0; i < n; i++){
            int len = 1;
            int prev = i;
            for(int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0 && f[j] + 1 > len){
                    len = f[j] + 1;
                    prev = j;
                }
            }
            //record new length and where the answer expand from
            f[i] = len;
            g[i] = prev;
        }

        //record max length and last element's index'
        int max = 0, idx = 0;
        for ( int i = 0; i < n; i ++){
            if(f[i] > max){
                max = f[i];
                idx = i;
            }
        }

        //trace back to get the answer
        List<Integer> ans = new ArrayList<>();
        while(ans.size()!= max){
            ans.add(nums[idx]);
            idx = g[idx];
        }
        return ans;
    }
}