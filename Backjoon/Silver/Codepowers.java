import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        int[] r = new int[n + 1];
        r[0] = x;
        for (int i = 0; i < n; i++) {
            r[i + 1] = r[i] + c[i];
        }
        int[] p = new int[n + 2];
        for (int i = 0; i <= n; i++) {
            p[i + 1] = p[i];
            if (r[i] < k) {
                p[i + 1]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());
            sb.append(p[rt] - p[l]).append('\n');
        }
        System.out.print(sb);
    }
}
