class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int num: nums){
            count.putIfAbsent(num, 0);
            count.put(num, count.get(num) + 1);
        }
    

    int maxFrequency = 0;
    int ans = 0;
    for(Map.Entry<Integer, Integer> entry: count.entrySet()){
        maxFrequency = Math.max(maxFrequency, entry.getValue());
    }
    for(Map.Entry<Integer, Integer> entry: count.entrySet()){
        if(entry.getValue() == maxFrequency) ans += maxFrequency;
    }

    return ans;
    }
}