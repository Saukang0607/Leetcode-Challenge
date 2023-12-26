class Solution:
    def hIndex(self, citations: List[int]) -> int:
        l, r = 0, len(citations)
        mid = (l + r + 1)//2
        while l<r:
            if sum(c >= mid for c in citations) >= mid:  #each qualified paper represents 1
                l = mid
            else:
                r = mid - 1
            mid = (l + r + 1)//2

        return l