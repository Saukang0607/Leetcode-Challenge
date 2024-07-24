class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int mapped[] = new int[nums.length];
        Integer[] idx = new Integer[nums.length];

        for(int i = 0; i < nums.length; i++){
            String numberString = Integer.toString(nums[i]);
            int rebuiltNumber = 0;
            for (int j = 0; j < numberString.length(); j++) {
                char digitChar = numberString.charAt(j);
                int index = Character.getNumericValue(digitChar);
                rebuiltNumber = rebuiltNumber * 10 + mapping[index];
            }
            mapped[i] = rebuiltNumber;
            idx[i] = i;
        }

        Arrays.sort(idx, (i, j) -> mapped[i] - mapped[j]);
        System.out.println(Arrays.toString(mapped));
        System.out.println(Arrays.toString(idx));

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[idx[i]];
        }
        return ans;
    }
}