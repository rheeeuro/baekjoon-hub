def solution(edges):
    n = len(edges)
    
    inCount = [0] * (1_000_001)
    outCount = [0] * (1_000_001)
    edgesDict = {}
    for edge in edges:
        outCount[edge[0]] += 1
        inCount[edge[1]] += 1
        if edge[0] not in edgesDict:
            edgesDict[edge[0]] = []
        if edge[1] not in edgesDict:
            edgesDict[edge[1]] = []
        edgesDict[edge[0]].append(edge[1])

        
    newIdx = 0
    zeroFigure = 0
    oneFigure = 0
    eightFigure = 0
    
    # 생성된 정점 구하기
    for i in range(1, n+1):
        if inCount[i] == 0 and outCount[i] >= 2:
            newIdx = i
            break
    
    for dest in edgesDict[newIdx]:
        outCount[newIdx] -= 1
        inCount[dest] -= 1
        if outCount[dest] == 0 and inCount[dest] == 0:
            oneFigure += 1

    # 8자 모양 그래프 갯수 구하기
    for i in range(1, n+1):
        if outCount[i] == 2:
            eightFigure += 1
            curIdx = i

            while outCount[curIdx] > 0:
                outCount[curIdx] -= 1
                for dest in edgesDict[curIdx]:
                    if inCount[dest] != 0:
                        curIdx = dest
                        break
                inCount[curIdx] -= 1
    
    
    # 막대 모양 그래프 갯수 구하기
    for i in range(1, n+1):
        if inCount[i] == 0 and outCount[i] == 1:
            oneFigure += 1
            curIdx = i

            while outCount[curIdx] > 0:
                outCount[curIdx] -= 1
                for dest in edgesDict[curIdx]:
                    if inCount[dest] != 0:
                        curIdx = dest
                        break
                inCount[curIdx] -= 1

    # 도넛 모양 그래프 갯수 구하기
    for i in range(1, n+1):
        if inCount[i] == 1 and outCount[i] == 1:
            zeroFigure += 1
            curIdx = i

            while outCount[curIdx] > 0:
                outCount[curIdx] -= 1
                for dest in edgesDict[curIdx]:
                    if inCount[dest] != 0:
                        curIdx = dest
                        break
                inCount[curIdx] -= 1

    return [newIdx, zeroFigure, oneFigure, eightFigure]
