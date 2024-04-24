from collections import deque

direction = [[0, 1], [1, 0], [-1, 0], [0, -1]]

def isValid(i, j, n, m):
    return 0 <= i < n and 0 <= j < m

def solution(land):
    n = len(land)
    m = len(land[0])
    visited = [[False] * m for _ in range(n)]
    countArr = [0] * m
    q = deque([])
    for i in range(n):
        for j in range(m):
            if land[i][j] == 1 and visited[i][j] == False:
                count = 0
                minIndex = j
                maxIndex = j
                q.append([i, j])
                while len(q) > 0:
                    cur = q.popleft()
                    if visited[cur[0]][cur[1]]:
                        continue
                    visited[cur[0]][cur[1]] = True
                    minIndex = min(minIndex, cur[1])
                    maxIndex = max(maxIndex, cur[1])
                    count += 1
                    for d in direction:
                        newI = cur[0] + d[0]
                        newJ = cur[1] + d[1]
                        if isValid(newI, newJ, n, m) and visited[newI][newJ] == False and land[newI][newJ] == 1:
                            q.append([newI, newJ])
                for idx in range(minIndex, maxIndex+1):
                    countArr[idx] += count

    return max(countArr)

        