class Solution:
    def romanToInt(self, s: str) -> int:
        hashmap = {"M":1000, "CM":900, "D":500, "CD":400, "C":100, "XC":90, "L":50, "XL":40, "X":10, "IX":9, "V":5, "IV":4, "I":1} 
        count = 0
        while len(s) >2 :
            if hashmap[s[0]] < hashmap[s[1]]:
                count += hashmap[s[1]] - hashmap[s[0]]
                s = s[2:]
            else:
                count += hashmap[s[0]]
                s = s[1:]
        if len(s) == 2 and hashmap[s[0]] < hashmap[s[1]]:
            count += hashmap[s[1]] - hashmap[s[0]]
        elif len(s) == 2:
            count += hashmap[s[0]] + hashmap[s[1]]
        else: 
            count += hashmap[s[0]]
        return count
        