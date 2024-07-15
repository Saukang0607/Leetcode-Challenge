class Solution:
    def countOfAtoms(self, formula: str) -> str:
        n = len(formula)
        map = defaultdict(lambda: 1)
        s = []
        i = idx = 0
        while i < n:
            c = formula[i]
            if c =='(' or c == ')':
                s.append(c)
                i += 1
            elif str.isdigit(c):
                j = i
                while j < n and str.isdigit(formula[j]): 
                    j+=1 #get the whole number
                cnt = int(formula[i:j])
                i = j
                
                if s and s[-1] == ')': #the number behind applies to all elements inside
                    tmp = [] #to maintain the elements of stack
                    s.pop()
                    while s and s[-1] != '(':
                        cur = s.pop()
                        map[cur] *= cnt
                        tmp.append(cur)
                    s.pop()

                    for k in range(len(tmp) - 1, -1, -1): 
                        s.append(tmp[k])
                else: #single atom followed by a number case
                    cur = s.pop()
                    map[cur] *= cnt
                    s.append(cur)

            else: #get the full atom name
                j = i + 1 #must start with capital letter
                if j < n and str.islower(formula[j]):
                    j += 1
                cur = formula[i:j] + "_" + str(idx) #tips in handling atom in different position
                idx += 1
                map[cur] = 1
                i = j
                s.append(cur)

        print(map)
        combined_map = defaultdict(lambda: 0)
        for key, cnt in map.items():
            atom = key.split("_")[0]
            combined_map[atom] += cnt
        
        ans = []
        for key in sorted(combined_map.keys()):
            cnt = combined_map[key]
            if cnt > 1:
                ans.append(key + str(cnt))
            else:
                ans.append(key)
        return "".join(ans)

