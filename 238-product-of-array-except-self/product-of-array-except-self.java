class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length; //draw ans[i] and nums[i] in table, diagonal will be 1
        int[] ans = new int[len];
        ans[0] = 1;
        int temp = 1;
        for(int i = 1; i < len; i++){ //lower triangle
            ans[i] = nums[i-1] * ans[i-1];
        }

        for(int i = len-2; i>-1; i--){//upper triangle
            temp *= nums[i+1];
            ans[i] *= temp;
        }
        
        return ans;
    }
}