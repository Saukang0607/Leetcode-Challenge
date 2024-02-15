class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long total = 0;
        for(int num: nums) total += num;
        for(int i = nums.length - 1; i >= 2; i--){
            if(total - 2 * nums[i] > 0) return total;
            else {
                total -= nums[i];
            }
        }
        return -1;
}
}