money = int(input())
change = 1000 - money

count = 0
curr = [500, 100, 50, 10, 5, 1]

for c in curr:
    while change >= c:
        change -= c
        count += 1

print(count)
