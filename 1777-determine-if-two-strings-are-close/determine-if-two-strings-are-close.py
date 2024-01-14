class Solution:
    def closeStrings(self, word1: str, word2: str) -> bool:
        count1 = [0] * 26
        count2 = [0] * 26
        for x in word1:
            count1[ord(x)-97] += 1
        
        for x in word2:
            count2[ord(x)-97] += 1
        
        for i in range(26):
            if (count1[i] == 0) ^ (count2[i] == 0): #there's a type of character which only appear in one string
                return False
        
        count1.sort()
        count2.sort()
        
        for i in range(26):
            if count1[i] != count2[i]:
                return False
        
        return True
