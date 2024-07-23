import sys


n = int(sys.stdin.readline().rstrip())

arr = []
for _ in range(n):
    arr.append(int(sys.stdin.readline().rstrip()))

for num in sorted(arr):
    print(num)
