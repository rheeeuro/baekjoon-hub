import sys

input = sys.stdin.readline
 
n = int(input())
arr = [*map(int, input().split())]
 
sortedArr = sorted(list(set(arr)))
dic = {sortedArr[i] : i for i in range(len(sortedArr))}

for num in arr:
    print(dic[num], end = ' ')