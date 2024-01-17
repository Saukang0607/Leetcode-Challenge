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

#17/1/2024 11:53, struggling on this easy question and probably going to die in next day intern
        