class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        n = len(positions)
        bots_info = sorted(zip(range(n), positions, healths, directions), key = lambda self:self[1])
        to_left = []
        to_right = [] 
        for i, p, h, d in bots_info:
            if d == "R":
                to_right.append([i,h])
                continue
            while to_right: #collision happened, left bot as candidate
                left = to_right[-1]
                if left[1] > h:
                    left[1] -= 1 
                    break
                if left[1] == h:
                    to_right.pop()
                    break
                h -= 1
                to_right.pop()
            else:
                to_left.append([i,h])
        to_right += to_left
        to_right.sort(key = lambda self:self[0])
        return [h for idx, h in to_right]
