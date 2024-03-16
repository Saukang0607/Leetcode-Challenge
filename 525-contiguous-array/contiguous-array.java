class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = nums[0] == 0 ? -1 : 1, ans = 0;
        map.put(sum, 0);
        for(int i = 1; i < nums.length; i++){
            sum = nums[i] == 0 ? sum - 1 : sum + 1;
            if(map.containsKey(sum)){
                ans = Math.max(ans, i - map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        return ans;
    }
}