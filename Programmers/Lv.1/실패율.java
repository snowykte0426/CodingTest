import java.util.Arrays;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[][] failRates = new double[N][2];
        int[] count = new int[N + 2];
        for (int stage : stages) {
            count[stage]++;
        }
        int totalPlayers = stages.length;
        for (int i = 0; i < N; i++) {
            failRates[i][0] = i + 1;

            if (totalPlayers == 0) {
                failRates[i][1] = 0;
            } else {
                failRates[i][1] = (double) count[i + 1] / totalPlayers;
            }
            totalPlayers -= count[i + 1];
        }
        Arrays.sort(failRates, (a, b) -> {
            if (b[1] == a[1]) {
                return Double.compare(a[0], b[0]);
            }
            return Double.compare(b[1], a[1]);
        });
        for (int i = 0; i < N; i++) {
            answer[i] = (int) failRates[i][0];
        }
        return answer;
    }
}
