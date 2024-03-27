class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i]-1, i);
            }
        }

        for(int i = 0; i < n; i++){
            if(nums[i]-1 != i) return i+1;
        }
        return n+1;
    }

    public void swap(int[]nums, int index1, int index2){
        int temp;
        temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}