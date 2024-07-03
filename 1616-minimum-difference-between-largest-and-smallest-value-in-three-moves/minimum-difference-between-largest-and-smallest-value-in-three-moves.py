class Solution:
    def minDifference(self, nums: List[int]) -> int:
        nums.sort()
        n = len(nums)
        if len(nums) <=4:
            return 0
        
        return min(nums[n - 4 + i] - nums[i] for i in range(4))
