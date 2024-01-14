class Solution:
    def minSteps(self, s: str, t: str) -> int:
        s_cnt = collections.Counter(s)
        ans = 0
        for char in t:
            if s_cnt[char] > 0:
                s_cnt[char] -= 1
            else:
                ans += 1
        return ans


        