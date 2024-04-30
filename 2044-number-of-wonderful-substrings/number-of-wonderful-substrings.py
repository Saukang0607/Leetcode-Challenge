class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        cnt = [0] * 1024
        cnt[0] = 1  # 初始前缀和为 0，需将其计入出现次数
        ans = s = 0
        for c in word:
            s ^= 1 << (ord(c) - ord('a'))  # 计算当前前缀和
            ans += cnt[s]  # 所有字母均出现偶数次
            ans += sum(cnt[s ^ (1 << i)] for i in range(10))  # 枚举其中一个字母出现奇数次，反转该字母的出现次数的奇偶性
            cnt[s] += 1  # 更新前缀和出现次数
        return ans
