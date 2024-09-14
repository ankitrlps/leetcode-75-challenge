class ReorderRoutesCityZero:
    
    def minReorder(self, n: int, connections: list[list[int]]) -> int:
        # start at city 0
        # recursively check its neighbors
        # count the number of outgoing edges or roads

        edges = { (a,b) for a, b in connections }
        neighbors = { city:[] for city in range(n) }
        visit = set()
        changes = 0

        for a, b in connections:
            neighbors[a].append(b)
            neighbors[b].append(a)

        def dfs(city):
            nonlocal edges, changes, neighbors, visit
            for neighbor in neighbors[city]:
                if neighbor in visit:
                    continue
                if (neighbor, city) not in edges:
                    changes += 1
                visit.add(neighbor)
                dfs(neighbor)
        visit.add(0)
        dfs(0)
        return changes
    
obj = ReorderRoutesCityZero()
print(obj.minReorder(6, [[0,1],[1,3],[2,3],[4,0],[4,5]]))