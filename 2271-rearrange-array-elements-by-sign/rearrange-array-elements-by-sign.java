class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] positive = new int[nums.length/2];
        int[] negative = new int[nums.length/2];
        int posIndex = 0;
        int negIndex = 0;
        for (int num : nums) {
            if (num > 0) {
                positive[posIndex++] = num;
            } else {
                negative[negIndex++] = num;
            }
        }
        
        int ptr = 0;
        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0 ){
                nums[i] = positive[ptr++];
            }
            else{
                nums[i] = negative[ptr - 1];
            }
        }
        return nums;
    }
}