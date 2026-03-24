n, k = map(int, input().split())
a = list()
sum_result = 0
count = 0
for i in range(n):
    a.append(int(input()))
a.sort(reverse=True)
for i in a:
    if k == 0:
        break
    count += k // i
    k = k % i
print(count)
