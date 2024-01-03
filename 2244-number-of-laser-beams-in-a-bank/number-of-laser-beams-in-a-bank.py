class Solution:
    def numberOfBeams(self, bank: List[str]) -> int:
        if len(bank) == 1:
            return 0
        total = 0
        upper = Counter(bank[0]) #highest row's devices number
        for i in range(1,len(bank)):
            lower = Counter(bank[i])
            total += upper['1'] * lower['1'] #combinations of laser beans
            if(lower['1'] != 0): #if that row has devices
                upper = lower
        return total
            
