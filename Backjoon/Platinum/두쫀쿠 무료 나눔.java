import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<long[]>[] graph = new List[N + 2];
        for (int i = 1; i <= N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            if (r % 2 == 0) continue;
            long cost = (long) r * (q - p + 1);
            graph[p].add(new long[]{q + 1, cost});
            graph[q + 1].add(new long[]{p, cost});
        }
        long[] dist = new long[N + 2];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0L, 1L});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];

            if (d > dist[u]) continue;

            for (long[] edge : graph[u]) {
                int v = (int) edge[0];
                long w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new long[]{dist[v], (long) v});
                }
            }
        }

        if (dist[N + 1] == Long.MAX_VALUE) {
            System.out.println("Dujjonku so expensive T.T");
        } else {
            System.out.println(dist[N + 1]);
        }
    }
}
