class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        n = len(positions)
        bots_info = sorted(zip(range(n), positions, healths, directions), key = lambda self:self[1])
        to_left = []
        stack = []
        for i, p, h, d in bots_info:
            if d == "R":
                stack.append([i,h])
                continue
            #bot will head left for below lines
            while stack: #collision happened, left bot as candidate
                left = stack[-1]
                if left[1] > h:
                    left[1] -= 1 
                    break
                if left[1] == h:
                    stack.pop()
                    break
                h -= 1
                stack.pop()
            else:
                to_left.append([i,h])
        stack += to_left
        stack.sort(key = lambda self:self[0])
        return [h for idx, h in stack]
