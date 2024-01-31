class Solution:
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        n = len(matrix)
        # dfs(r, c) 表示从 matrix[r][c] 出发，向上走到第一行的最小路径和
        @cache  # 记忆化搜索
        def dfs(r: int, c: int) -> int:
            if c < 0 or c >= n:  # 出界
                return inf
            if r == 0:  # 到达第一行
                return matrix[0][c]
            return min(dfs(r - 1, c - 1), dfs(r - 1, c), dfs(r - 1, c + 1)) + matrix[r][c]
        return min(dfs(n - 1, i) for i in range(n))  # 枚举起点，取最小值
