class Solution {
    public int solution(int a, int b, int c) {
        if (a != b && b != c && c != a) return a + b + c;
        else if ((a == b && b != c) || (a == c && c != b) || (b == c && c != a))
            return (a + b + c) * ((int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2));
        return (a + b + c) * ((int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2)) * ((int) Math.pow(a, 3) + (int) Math.pow(b, 3) + (int) Math.pow(c, 3));
    }
}
