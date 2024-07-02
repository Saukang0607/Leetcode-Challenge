class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<Integer>();
        int left_ptr = 0, right_ptr = 0;
        while(left_ptr < nums1.length && right_ptr < nums2.length){
            if(nums1[left_ptr] == nums2[right_ptr]){
                ans.add(nums1[left_ptr]);
                left_ptr++;
                right_ptr++;
            }
            else if(nums1[left_ptr] > nums2[right_ptr]) right_ptr++;
            else left_ptr++;
        }
        
        // Convert ArrayList to int array
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}