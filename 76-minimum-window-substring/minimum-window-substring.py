class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = Counter(t)
        needCnt = len(t)
        i = 0
        res = (0,float('inf'))
        for j, c in enumerate(s):
            if need[c] > 0:
                needCnt -= 1
            need[c] -= 1
            if needCnt == 0:
                while True:
                    c = s[i]
                    if need[c] == 0: #found a char that is in t
                        break
                    need[c] += 1
                    i += 1
                if j - i < res[1] - res[0]:
                    res = (i, j)
                need[s[i]] += 1
                needCnt += 1
                i+=1
        return "" if res[1] > len(s) else s[res[0]: res[1]+ 1]
            