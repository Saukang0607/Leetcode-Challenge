import numpy as np

class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        length = len(gas)
        remain = 0
        minRemain = np.inf
        minIndex = 0
        for i in range(length):
            remain += gas[i] - cost[i]
            if remain < minRemain:
                minRemain = remain
                minIndex = i
        
        if remain < 0:
            return -1
        elif minRemain >= 0:
            return 0
        else:
            return minIndex + 1

            