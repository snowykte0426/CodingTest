class Solution {
    public int solution(int a, int b) {
        if (isOdd(a) && isOdd(b)) return (int) Math.pow(a, 2) + (int) Math.pow(b, 2);
        else if (isOdd(a) || isOdd(b)) return 2 * (a + b);
        else return Math.abs(a - b);
    }

    private boolean isOdd(int num) {
        return num % 2 != 0;
    }
}
