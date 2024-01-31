def solution(n, works):
#     while(n > 0):
#         m = 0
#         mIdx = -1
#         for i in range(len(works)):
#             if (works[i] > m):
#                 m = works[i]
#                 mIdx = i          
#         if mIdx == -1:
#             break
            
#         works[mIdx] -= 1
#         n -= 1
    sortedWorks = sorted(works, reverse=True)
    idx = 0
    while(idx < len(sortedWorks) and n > 0):
        diff = 0
        if idx == len(sortedWorks) - 1:
            diff = sortedWorks[idx]
        else:
            diff = sortedWorks[idx] - sortedWorks[idx+1]
        if diff * (idx+1) > n:
            while (n > 0):
                for i in range(idx+1):
                    sortedWorks[i] -= 1
                    n -= 1
                    if (n == 0):
                        break
            break
        else:
            for i in range(idx + 1):
                sortedWorks[i] -= diff
                n -= diff
        idx += 1
            
    
        
    score = 0
    for w in sortedWorks:
        score += w * w
    return score