class Solution:
    def findWinners(self, matches: List[List[int]]) -> List[List[int]]:
        losesCount = {} #hashmap
        for x,y in matches:
            if x not in losesCount:
                losesCount[x] = 0
            if y not in losesCount:
                losesCount[y] = 0
            losesCount[y] += 1

        winners = []
        losers = []
        for x in losesCount:
            if losesCount[x] == 0:
                winners.append(x)
            elif losesCount[x] == 1:
                losers.append(x)
        
        winners.sort()
        losers.sort()
        return [winners, losers]

        