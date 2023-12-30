class Solution:
    def trap(self, height: List[int]) -> int:
        sum = 0
        max_left = [0] * len(height) #the tallest wall at its left
        max_right = [0] * len(height) #the tallest wall at its right

        for l in range(1,len(height)-1):
            max_left[l] = max(height[l-1],max_left[l-1])
        
        for r in range(len(height)-2,0,-1):
            max_right[r] = max(height[r+1],max_right[r+1])
        
        for i in range(1,len(height)-1):
            minimum = min(max_left[i],max_right[i])
            if minimum > height[i]:
                sum += minimum-height[i] #calculating the volume of that column
        
        return sum