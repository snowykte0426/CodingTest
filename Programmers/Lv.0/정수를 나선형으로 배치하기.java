class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int value = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n - i; j++) {
                answer[i][j] = ++value;
            }
            for(int j = i + 1; j < n - i; j++) {
                answer[j][n - i - 1] = ++value;
            }
            for(int j = n - i - 2; j >= i; j--) {
                answer[n - i - 1][j] = ++value;
            }
            for(int j = n - i - 2; j > i; j--) {
                answer[j][i] = ++value;
            }
        }
        return answer;
    }
}
