class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        n = len(arr)
        # 左边界 left[i] 为左侧严格小于 arr[i] 的最近元素位置（不存在时为 -1）
        left, st = [-1] * n, []
        for i, x in enumerate(arr):
            while st and arr[st[-1]] >= x:
                st.pop()  # 移除无用数据
            if st: left[i] = st[-1]
            st.append(i)

        # 右边界 right[i] 为右侧小于等于 arr[i] 的最近元素位置（不存在时为 n）
        right, st = [n] * n, []
        for i in range(n - 1, -1, -1):
            while st and arr[st[-1]] > arr[i]:
                st.pop()  # 移除无用数据
            if st: right[i] = st[-1]
            st.append(i)

        ans = 0
        for i, (x, l, r) in enumerate(zip(arr, left, right)):
            ans += x * (i - l) * (r - i)  # 累加贡献
        return ans % (10 ** 9 + 7)
