class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        tail, res = [0] * len(nums), 0
        for num in nums:
            i, j = 0, res
            while i != j:
                m = (i+j) // 2
                if tail[m] < num: i = m + 1
                else: j = m
            tail[j] = num
            if j == res: res += 1 #num is bigger than the longest tail
        return res