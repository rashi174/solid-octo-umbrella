class Solution:
    def canVisitAllRooms(self, rooms: List[List[int]]) -> bool:
        stack = [0]  #To do keys
        visited = [False] * len(rooms)
        visited[0] = True
        while stack:
            key=stack.pop()
            for otherkeys in rooms[key]:
                if visited[otherkeys]==False:
                    visited[otherkeys]=True
                    stack.append(otherkeys)
        return all(visited)