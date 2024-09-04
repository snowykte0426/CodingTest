def solve(n, w, top, bottom):
    INF = 10 ** 9

    def dp_solve(first_pair, last_pair):
        dp = [[INF] * 3 for _ in range(n)]
        dp[0][0] = 2
        if top[0] + bottom[0] <= w:
            dp[0][0] = 1
        for i in range(1, n):
            dp[i][0] = dp[i - 1][0] + 2
            if top[i] + bottom[i] <= w:
                dp[i][0] = min(dp[i][0], dp[i - 1][0] + 1)
            if i > 1 and top[i - 1] + top[i] <= w:
                dp[i][1] = min(dp[i][1], dp[i - 2][0] + 1)
            if i > 1 and bottom[i - 1] + bottom[i] <= w:
                dp[i][2] = min(dp[i][2], dp[i - 2][0] + 1)
        result = min(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2])
        if first_pair and top[0] + top[n - 1] <= w:
            result = min(result, dp[n - 1][0])
        if last_pair and bottom[0] + bottom[n - 1] <= w:
            result = min(result, dp[n - 1][0])
        return result

    return min(dp_solve(False, False), dp_solve(True, False), dp_solve(False, True), dp_solve(True, True))


def main():
    t = int(input())
    for _ in range(t):
        n, w = map(int, input().split())
        top = list(map(int, input().split()))
        bottom = list(map(int, input().split()))
        result = solve(n, w, top, bottom)
        print(result)


if __name__ == "__main__":
    main()
