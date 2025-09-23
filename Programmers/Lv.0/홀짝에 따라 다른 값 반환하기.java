class Solution {
    public int solution(int n) {
        return n % 2 == 0 ? evenSquare(n) : oddSum(n);
    }

    private int oddSum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i += 2) {
            sum += i;
        }
        return sum;
    }

    private int evenSquare(int n) {
        int sum = 0;
        for (int i = 2; i <= n; i += 2) {
            sum += i * i;
        }
        return sum;
    }
}
