# LCS (12분 / 30분)

line1 = input()
line2 = input()

arr = [[0] * (len(line2)+1) for _ in range(len(line1)+1)]

for a in range(1, len(line1)+1):
    for b in range(1, len(line2)+1):
        if line1[a-1] == line2[b-1]:
            arr[a][b] = arr[a-1][b-1] + 1
        else:
            arr[a][b] = max(arr[a][b-1], arr[a-1][b])


print(arr[len(line1)][len(line2)])
