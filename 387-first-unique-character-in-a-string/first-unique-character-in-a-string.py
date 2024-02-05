class Solution:
    def firstUniqChar(self, s: str) -> int:
        hashMap = OrderedDict()  # Use OrderedDict to maintain character order
        idx = -1
        for char in s:
            hashMap[char] = hashMap.get(char, 0) + 1  # Count character occurrences
        
        for x in hashMap:
            if(hashMap[x] != 1):
                idx += hashMap[x]
            elif (hashMap[x] == 1):
                return s.find(x)
        return -1