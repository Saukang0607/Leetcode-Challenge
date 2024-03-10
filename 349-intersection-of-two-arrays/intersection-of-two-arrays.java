class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> array1 = new HashSet<Integer>();
        Set<Integer> array2 = new HashSet<Integer>();
        for(int num: nums1){
            array1.add(num);
        }
        for(int num:nums2){
            array2.add(num);
        }
        return findIntersect(array1, array2);
    }
    public int[] findIntersect(Set<Integer> nums1, Set<Integer> nums2){
        ArrayList<Integer> ans = new ArrayList<>(); //use array list (dynamic array)
        if(nums1.size()> nums2.size()){
            for(int num: nums2){
                if(nums1.contains(num)){
                    ans.add(num);
                }
            }
            return ans.stream().mapToInt(i -> i).toArray();  // Convert to int[]
        }
        else{
            for(int num: nums1){
                if(nums2.contains(num)){
                    ans.add(num);
                }
            }
            return ans.stream().mapToInt(i -> i).toArray();  // Convert to int[]
        }
    }
}