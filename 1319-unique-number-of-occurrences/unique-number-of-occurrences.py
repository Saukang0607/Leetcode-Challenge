class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        count = Counter(arr)
        check = []
        for x in count.values():
            if x not in check:
                check.append(x)
            else: 
                return False
        return True
        