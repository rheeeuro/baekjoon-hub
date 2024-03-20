def solution(new_id):
    # 1단계
    new_id = new_id.lower()
    
    # 2단계, 3단계
    new_id_arr = []
    for i in range(len(new_id)):
        if new_id[i].isalpha() or new_id[i].isnumeric() or new_id[i] == '-' or new_id[i] == '_' or new_id[i] == '.':
            if new_id[i] == '.' and len(new_id_arr) > 0 and new_id_arr[-1] == '.':
                continue
            new_id_arr.append(new_id[i])
    
    # 4단계
    while len(new_id_arr) > 0 and new_id_arr[0] == '.':
        new_id_arr = new_id_arr[1:]
    while len(new_id_arr) > 0 and new_id_arr[-1] == '.':
        new_id_arr = new_id_arr[:-1]
    
    # 5단계
    if len(new_id_arr) == 0:
        new_id_arr.append('a')
    
    # 6단계
    if len(new_id_arr) > 15:
        new_id_arr = new_id_arr[:15]
    while len(new_id_arr) > 0 and new_id_arr[-1] == '.':
        new_id_arr = new_id_arr[:-1]
    
    # 7단계
    if len(new_id_arr) <= 2:
        while len(new_id_arr) != 3:
            new_id_arr.append(new_id_arr[-1])
        
    answer = ''
    return ''.join(new_id_arr)