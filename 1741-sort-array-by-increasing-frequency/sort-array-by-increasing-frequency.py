import numpy as np

class Solution:
    def frequencySort(self, nums: List[int]) -> List[int]:
        map = Counter(nums)
        data = [[num, count] for num, count in map.items()]
        data.sort(key=lambda x: (x[1], -x[0]))  
        ans = []
        for key,value in data:
            ans.extend([key] * value)
        return ans
