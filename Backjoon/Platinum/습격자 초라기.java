import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = c - '0';
            while ((c = read()) > ' ') val = val * 10 + c - '0';
            return val * sign;
        }
    }

    static final int INF = 1_000_000_000;

    static int solve(int n, int w, int[] top, int[] bottom) {
        if (n == 1) return top[1] + bottom[1] <= w ? 1 : 2;

        int ans = INF;

        for (int start = 0; start < 4; start++) {
            if ((start & 1) != 0 && top[1] + top[n] > w) continue;
            if ((start & 2) != 0 && bottom[1] + bottom[n] > w) continue;

            int[] dp = new int[4];
            Arrays.fill(dp, INF);
            dp[start] = 0;

            for (int i = 1; i <= n; i++) {
                boolean topH = top[i] + (i == n ? top[1] : top[i + 1]) <= w;
                boolean bottomH = bottom[i] + (i == n ? bottom[1] : bottom[i + 1]) <= w;

                int[] next = new int[4];
                Arrays.fill(next, INF);

                for (int mask = 0; mask < 4; mask++) {
                    int cur = dp[mask];
                    if (cur == INF) continue;

                    boolean topFree = (mask & 1) == 0;
                    boolean bottomFree = (mask & 2) == 0;

                    if (!topFree && !bottomFree) {
                        next[0] = Math.min(next[0], cur);
                    } else if (topFree && !bottomFree) {
                        next[0] = Math.min(next[0], cur + 1);
                        if (topH) next[1] = Math.min(next[1], cur + 1);
                    } else if (!topFree) {
                        next[0] = Math.min(next[0], cur + 1);
                        if (bottomH) next[2] = Math.min(next[2], cur + 1);
                    } else {
                        next[0] = Math.min(next[0], cur + 2);
                        if (top[i] + bottom[i] <= w) next[0] = Math.min(next[0], cur + 1);
                        if (topH) next[1] = Math.min(next[1], cur + 2);
                        if (bottomH) next[2] = Math.min(next[2], cur + 2);
                        if (topH && bottomH) next[3] = Math.min(next[3], cur + 2);
                    }
                }
                dp = next;
            }
            ans = Math.min(ans, dp[start]);
        }

        return ans;
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();
        StringBuilder sb = new StringBuilder();
        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int w = fs.nextInt();
            int[] top = new int[n + 1];
            int[] bottom = new int[n + 1];

            for (int i = 1; i <= n; i++) top[i] = fs.nextInt();
            for (int i = 1; i <= n; i++) bottom[i] = fs.nextInt();

            sb.append(solve(n, w, top, bottom)).append('\n');
        }

        System.out.print(sb);
    }
}
