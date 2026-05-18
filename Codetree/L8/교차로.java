import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(System.in));
        int n = ni(in);
        int[] t = new int[n];
        int[] w = new int[n];
        int[] ans = new int[n];
        ArrayDeque<Integer>[] q = new ArrayDeque[4];
        for (int i = 0; i < 4; i++) q[i] = new ArrayDeque<>();
        int[][] byPos = new int[4][n];
        int[] cnt = new int[4];
        for (int i = 0; i < n; i++) {
            t[i] = ni(in);
            w[i] = nc(in) - 'A';
            ans[i] = -1;
            byPos[w[i]][cnt[w[i]]++] = i;
        }
        int[] ptr = new int[4];
        long time = 0;
        int done = 0;
        while (done < n) {
            for (int i = 0; i < 4; i++) {
                while (ptr[i] < cnt[i] && t[byPos[i][ptr[i]]] <= time) {
                    q[i].addLast(byPos[i][ptr[i]++]);
                }
            }
            int passMask = 0;
            for (int i = 0; i < 4; i++) {
                if (!q[i].isEmpty() && q[(i + 3) % 4].isEmpty()) passMask |= 1 << i;
            }
            if (passMask != 0) {
                for (int i = 0; i < 4; i++) {
                    if ((passMask & (1 << i)) != 0) {
                        ans[q[i].pollFirst()] = (int) time;
                        done++;
                    }
                }
                time++;
            } else {
                boolean allFull = true;
                for (int i = 0; i < 4; i++) if (q[i].isEmpty()) { allFull = false; break; }
                boolean allDoneArriving = true;
                for (int i = 0; i < 4; i++) if (ptr[i] < cnt[i]) { allDoneArriving = false; break; }
                if (allFull && allDoneArriving) break;
                long nextT = Long.MAX_VALUE;
                for (int i = 0; i < 4; i++) {
                    if (ptr[i] < cnt[i]) {
                        long tt = t[byPos[i][ptr[i]]];
                        if (tt < nextT) nextT = tt;
                    }
                }
                if (nextT == Long.MAX_VALUE) break;
                time = Math.max(time + 1, nextT);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(ans[i]).append('\n');
        System.out.print(sb);
    }

    private static int ni(DataInputStream in) throws IOException {
        int c, r = 0;
        do { c = in.read(); } while (c != -1 && (c <= ' '));
        boolean neg = false;
        if (c == '-') { neg = true; c = in.read(); }
        while (c > ' ') { r = r * 10 + c - '0'; c = in.read(); }
        return neg ? -r : r;
    }

    private static int nc(DataInputStream in) throws IOException {
        int c;
        do { c = in.read(); } while (c != -1 && c <= ' ');
        return c;
    }
}
