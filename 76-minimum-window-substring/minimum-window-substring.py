class Solution:
    def minWindow(self, s: str, t: str) -> str:
        need = Counter(t)
        needCnt = len(t)
        res = (0, float('inf'))
        i = 0
        for j,x in enumerate(s):
            if need[x] > 0:
                needCnt -= 1
            need[x] -= 1
            if needCnt == 0: #step 1: found a valid window
                while True: #step 2: increase i (shorten the window)
                    if need[s[i]] == 0: #cannot throw anymore
                        break
                    need[s[i]] += 1
                    i += 1 #throwing unwanted elements
                if j-i < res[1]-res[0]: #recording minimum
                    res = (i,j)
                need[s[i]] += 1 #step 3: repeat step 1 to find another window
                needCnt += 1
                i += 1
        return '' if res[1] > len(s) else s[res[0]:res[1]+1]
