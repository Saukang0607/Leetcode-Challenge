class Solution:
    def candy(self, ratings: List[int]) -> int:
        left = [1 for _ in range(len(ratings))]
        right = left[:]
        for i in range(1,len(ratings)):
            if ratings[i] > ratings[i-1]: 
                left[i] = left[i-1] + 1
        count = left[-1]
        for j in range(len(ratings)-2,-1,-1):
            if ratings[j] > ratings[j+1]:
                right[j] = right[j+1] + 1
            count += max(left[j],right[j])
        return count