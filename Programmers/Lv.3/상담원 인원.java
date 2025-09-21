import java.util.*;

class Solution {
    public int solution(int k, int n, int[][] reqs) {
        List<List<int[]>> byType = new ArrayList<>();
        for (int i = 0; i < k; i++) byType.add(new ArrayList<>());
        for (int[] r : reqs) {
            int a = r[0], b = r[1], c = r[2] - 1;
            byType.get(c).add(new int[]{a, b});
        }

        int[] mentors = new int[k];
        Arrays.fill(mentors, 1);
        int remain = n - k;

        long[] curWait = new long[k];
        long[] nextWait = new long[k];
        long total = 0;
        for (int i = 0; i < k; i++) {
            curWait[i] = waitingTime(byType.get(i), mentors[i]);
            nextWait[i] = waitingTime(byType.get(i), mentors[i] + 1);
            total += curWait[i];
        }

        while (remain > 0) {
            int best = 0;
            long bestGain = 0;
            for (int i = 0; i < k; i++) {
                long gain = curWait[i] - nextWait[i];
                if (gain > bestGain) {
                    bestGain = gain;
                    best = i;
                }
            }
            mentors[best]++;
            remain--;
            total -= (curWait[best] - nextWait[best]);
            curWait[best] = nextWait[best];
            nextWait[best] = waitingTime(byType.get(best), mentors[best] + 1);
        }
        return (int) total;
    }

    private long waitingTime(List<int[]> reqs, int m) {
        if (reqs.isEmpty() || m <= 0) return 0L;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long wait = 0L;
        for (int[] r : reqs) {
            int a = r[0];
            int b = r[1];
            while (!pq.isEmpty() && pq.peek() <= a) pq.poll();
            if (pq.size() < m) {
                pq.offer(a + b);
            } else {
                int finish = pq.poll();
                wait += (finish - a);
                pq.offer(finish + b);
            }
        }
        return wait;
    }
}
