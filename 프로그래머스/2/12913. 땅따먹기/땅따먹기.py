# def solution(land):
#     return dfs(0, land, -1, 0)

# def dfs(i, land, prevIndex, score):
#     if (i == len(land)):
#         return score
    
#     m = score
#     for j in range(4):
#         if j != prevIndex:
#             m = max(m, dfs(i+1, land, j, score + land[i][j]))

#     return m

def solution(land):
    dp = [[0] * 4 for _ in range(len(land))]
    
    dp[0][0] = land[0][0]
    dp[0][1] = land[0][1]
    dp[0][2] = land[0][2]
    dp[0][3] = land[0][3]
    
    for i in range(1, len(land)):
        for j in range(4):
            arr = []
            for k in range(4):
                if j != k:
                    arr.append(dp[i-1][k])
            dp[i][j] = max(arr) + land[i][j]
    
            
    return max(dp[len(land)-1])