class Solution {
    public int findMaxK(int[] nums) {
        if(nums.length == 1) return -1; //edge case
        Arrays.sort(nums);
        int front = 0, back = nums.length - 1;
        while(front <= back){
            if(nums[front] * -1 == nums[back]){
                return nums[back];
            }
            if(nums[front] * -1 > nums[back]){
                front++;
            }
            else{
                back--;
            }
        }
        return -1;
    }
}