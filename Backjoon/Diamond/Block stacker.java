import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        int K = fs.nextInt();
        int W = fs.nextInt();
        int H = fs.nextInt();

        ArrayList<Integer>[] byColor = new ArrayList[K + 1];
        for (int i = 1; i <= K; i++) byColor[i] = new ArrayList<>();
        for (int i = 1; i <= K; i++) {
            int c = fs.nextInt();
            byColor[c].add(i);
        }

        boolean[][] possible = new boolean[K + 1][W + 1];
        ArrayList<Integer> colors = new ArrayList<>();
        for (int c = 1; c <= K; c++) {
            if (byColor[c].isEmpty()) continue;
            colors.add(c);
            possible[c][0] = true;
            for (int s : byColor[c]) {
                for (int x = s; x <= W; x++) {
                    if (possible[c][x - s]) possible[c][x] = true;
                }
            }
        }

        long[][] end = new long[K + 1][W + 1];
        long[] full = new long[W + 1];
        full[0] = 1;

        for (int n = 1; n <= W; n++) {
            long sumAll = 0;
            for (int c : colors) {
                long v = 0;
                for (int len = 1; len <= n; len++) {
                    if (!possible[c][len]) continue;
                    int prev = n - len;
                    long add = full[prev];
                    if (prev > 0) add = (add - end[c][prev] + MOD) % MOD;
                    v += add;
                    if (v >= MOD) v -= MOD;
                }
                end[c][n] = v;
                sumAll += v;
                if (sumAll >= MOD) sumAll -= MOD;
            }
            full[n] = sumAll;
        }

        long[] prev = new long[W + 1];
        Arrays.fill(prev, 1);

        for (int h = 1; h <= H; h++) {
            long[] g = new long[W + 1];
            for (int len = 1; len <= W; len++) {
                g[len] = full[len] * prev[len] % MOD;
            }

            long[] dp0 = new long[W + 1];
            long[] dp1 = new long[W + 1];
            dp0[0] = 1;

            for (int i = 0; i <= W; i++) {
                if (i < W) {
                    dp0[i + 1] += dp0[i] + dp1[i];
                    dp0[i + 1] %= MOD;
                }
                long base = dp0[i];
                if (base == 0) continue;
                for (int len = 1; i + len <= W; len++) {
                    if (g[len] == 0) continue;
                    dp1[i + len] += base * g[len] % MOD;
                    if (dp1[i + len] >= MOD) dp1[i + len] -= MOD;
                }
            }

            long[] cur = new long[W + 1];
            for (int n = 0; n <= W; n++) {
                cur[n] = (dp0[n] + dp1[n]) % MOD;
            }
            prev = cur;
        }

        System.out.println(prev[W] % MOD);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

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
            do c = read(); while (c <= ' ' && c != -1);
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val * sign;
        }
    }
}
