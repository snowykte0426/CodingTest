def blackjack() :
    n, m = input().split()
    n = int(n)
    m = int(m)
    card_list = list(map(int, input().split()))
    max_sum = 0
    for i in range(n):
        for j in range(i+1, n):
            for k in range(j+1, n):
                sum = card_list[i] + card_list[j] + card_list[k]
                if sum <= m and sum > max_sum:
                    max_sum = sum
    print(max_sum)
    return None

blackjack()
