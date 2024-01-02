class Solution:
    def findMatrix(self, nums: List[int]) -> List[List[int]]:
        ans = []
        count = Counter(nums)
        while count: #hashmap is not empty
            ans.append(list(count))
            for x in ans[-1]: 
                count[x] -= 1
                if count[x] == 0:
                    del count[x]
        return ans
        