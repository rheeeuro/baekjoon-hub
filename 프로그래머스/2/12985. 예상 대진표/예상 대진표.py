def solution(n,a,b):
    low = 0
    high = 0
    
    if a > b:
        low = b
        high = a
    else:
        low = a
        high = b
        
    arr = [i for i in range(1, n+1)]
    c = 1
    round = 1
    
    while c != n:
        new_arr = []
        for i in range(int(len(arr)/2)):
            one = arr[i * 2]
            two = arr[i * 2 + 1]
            if one == low and two == high:
                break
            elif one == low or one == high:
                new_arr.append(one)
            elif two == low or two == high:
                new_arr.append(two)
            else:
                new_arr.append(one)
        if len(new_arr) * 2 != len(arr):
            break
        else:
            arr = new_arr
        c *= 2
        round += 1

    return round