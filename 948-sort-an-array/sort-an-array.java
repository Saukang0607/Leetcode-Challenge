class Solution {
    public int[] sortArray(int[] nums) {
        //insertion sort
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int temp = nums[i];
            int j = i;
            while(j > 0 && nums[j-1] > temp){
                nums[j] = nums[j-1];
                j--;
            }
            nums[j] = temp;
        }
        return nums;
    }
}