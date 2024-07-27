class Solution:
    def minimumCost(self, source: str, target: str, original: List[str], changed: List[str], cost: List[int]) -> int:
        c = [[inf] * 26 for _ in range(26)] #c[i][j] = minimum cost of converting i to j
        for i in range(26):
            c[i][i] = 0
        
        for x, y, z in zip(original, changed, cost):
            x = ord(x) - ord('a')
            y = ord(y) - ord('a')
            c[x][y] = min(c[x][y], z) 
        
        for k in range(26):
            for i in range(26):
                for j in range(26):
                    c[i][j] = min(c[i][j], c[i][k] + c[k][j]) 
        
        ans = sum(c[ord(x) - ord('a')][ord(y) - ord('a')] for x, y in zip(source, target))
        return ans if ans < inf else -1