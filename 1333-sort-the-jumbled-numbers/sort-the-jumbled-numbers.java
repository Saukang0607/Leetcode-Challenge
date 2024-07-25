class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int mapped[] = new int[nums.length]; //stores mapped version nums
        Integer[] idx = new Integer[nums.length]; //stores sorted mapped indexes

        for(int i = 0; i < nums.length; i++){
            String numberString = Integer.toString(nums[i]);
            int rebuiltNumber = 0;
            for (int j = 0; j < numberString.length(); j++) { //mapping nums[i] digit one by one
                char digitChar = numberString.charAt(j);
                int index = Character.getNumericValue(digitChar);
                rebuiltNumber = rebuiltNumber * 10 + mapping[index];
            }
            mapped[i] = rebuiltNumber;
            idx[i] = i;
        }

        Arrays.sort(idx, (i, j) -> mapped[i] - mapped[j]); //sort indexes based on non-decreasing order of mapped

        int[] ans = new int[nums.length]; //create new answer array to prevent overwrite
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[idx[i]];
        }
        return ans;
    }
}