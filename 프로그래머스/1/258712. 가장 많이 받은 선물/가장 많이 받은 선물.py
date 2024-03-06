def solution(friends, gifts):
    n = len(friends)
    data = [[0] * n for _ in range(n)]
    score = [0] * n
    result = [[0] * n for _ in range(n)]
    answer = 0
    
    # 주고받은 선물
    for gift in gifts:
        gfrom, gto = map(friends.index, gift.split())
        data[gfrom][gto] += 1
    
    # 선물지수
    for i in range(n):
        to_num = 0
        from_num = 0
        for a in range(n):
            from_num += data[i][a]
            to_num += data[a][i]
        score[i] = from_num - to_num
    
    # 다음달에 가장 선물을 많이 받는 사람
    for i in range(n):
        present_num = 0
        for j in range(n):
            if i == j:
                continue
            if data[i][j] > data[j][i] or (data[i][j] == data[j][i] and score[i] > score[j]):
                present_num += 1
        if answer < present_num:
            answer = present_num
        
    
    return answer