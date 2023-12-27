class Solution: #left rule: right kid get more candy if ratings is higher than his left kid
                #right rule: left kid get more candy if ratings is higher than his right kid
                #to solve this problem, both rules need to be fulfilled
    def candy(self, ratings: List[int]) -> int:
        left = [1 for _ in range(len(ratings))] #give all kids one candy
        right = left[:] 
        for i in range(1,len(ratings)): //implementing left rule
            if ratings[i] > ratings[i-1]: 
                left[i] = left[i-1] + 1
        count = left[-1]
        for j in range(len(ratings)-2,-1,-1): //implementing right rule
            if ratings[j] > ratings[j+1]:
                right[j] = right[j+1] + 1
            count += max(left[j],right[j])
        return count
