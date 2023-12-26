class RandomizedSet {
    static int[] nums = new int[200001];
    Random random = new Random();
    Map<Integer, Integer> map = new HashMap<>();
    int idx = -1;
    
    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        nums[++idx] = val;
        map.put(val, idx);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)){
            return false;
        }
        int loc = map.remove(val); //get the original index of removed element
        if(idx != loc)
            map.put(nums[idx], loc); //swap the last element to the removed element's index
        nums[loc] = nums[idx--]; 
        return true;
    }

    public int getRandom() {
        return nums[random.nextInt(idx+1)];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */