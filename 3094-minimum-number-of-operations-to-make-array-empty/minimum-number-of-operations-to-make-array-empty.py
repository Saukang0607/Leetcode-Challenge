class Solution:
    def minOperations(self, nums: List[int]) -> int:
        count = Counter(nums)
        ans = 0
        for x in count:
            if count[x] >= 3:
                ans += math.ceil(count[x]/ 3)
                count[x] = 0
            elif count[x] == 2:
                ans += 1
                count[x] = 0
        if sum(count.values()) != 0:
            return -1
        return ans