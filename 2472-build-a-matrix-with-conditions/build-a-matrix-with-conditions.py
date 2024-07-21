class Solution:
    def buildMatrix(self, k: int, rowConditions: List[List[int]], colConditions: List[List[int]]) -> List[List[int]]:
        def topo_sort(edges: List[List[int]]) -> List[int]:
            out_deg_set = [[] for _ in range(k)]
            in_deg = [0] * k
            for x,y in edges:
                out_deg_set[x-1].append(y-1)
                in_deg[y-1] += 1
            order = []
            queue = deque(i for i, _ in enumerate(in_deg) if _ == 0) #the elements that will stay on top/left
            while queue:
                element = queue.popleft()
                order.append(element)
                for out in out_deg_set[element]:
                    in_deg[out] -= 1
                    if in_deg[out] == 0:
                        queue.append(out)
            
            if len(order) == k:
                return order
            return None
        
        row_order = topo_sort(rowConditions)
        col_order = topo_sort(colConditions)
        if row_order is None or col_order is None: #there is a cycle in topological order, answer didn't exist
            return []
        pos = {x:i for i, x in enumerate(col_order)} #dictionary of value:index
        ans = [[0] * k for _ in range(k)]
        for i, x in enumerate(row_order):
            ans[i][pos[x]] = x+1
        return ans


        