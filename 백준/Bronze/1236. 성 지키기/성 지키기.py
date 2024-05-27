# 성 지키기 (20분 / 20분)

nm = input().split()
n = int(nm[0])
m = int(nm[1])
arr = []
for _ in range(n):
    arr.append(input())

counterN = [0] * n
counterM = [0] * m
for idx, line in enumerate(arr):
    if 'X' in line:
        counterN[idx] = 1
    for i, c in enumerate(line):
        if c == 'X':
            counterM[i] = 1

print(max(n-counterN.count(1), m-counterM.count(1)))
