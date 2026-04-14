n = int(input())
k = list(map(int, input().split()))
pi = list(map(int, input().split()))

c = pi[0]
total = 0

for i in range(n-1):
    if pi[i] < c:
        c = pi[i]
    total += c * k[i]

print(total)
