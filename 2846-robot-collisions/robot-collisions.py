class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        n = len(positions)
        bots_info = sorted(zip(range(n), positions, healths, directions), key = lambda self_:self_[1])
        to_left = []
        to_right = [] 
        for i, p, h, d in bots_info:
            if d == "R":
                to_right.append([i,h])
                continue
            while to_right: #encountered bot to left, collision happened
                rightmost = to_right[-1]
                if rightmost[1] > h:
                    rightmost[1] -= 1 
                    #no need to pop the bot heading left since we never append it before
                    break
                elif rightmost[1] == h:
                    to_right.pop()
                    break
                h -= 1
                to_right.pop()
            else: #bots to right are all collided by a large health bot (loop didn't break)
                to_left.append([i,h])
        to_right += to_left #at the end all bots will head toward same direction
        to_right.sort(key = lambda self_:self_[0])
        return [h for idx, h in to_right]