import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 998244353;
    
    static long pow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = res * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
    
    static long inv(long x) {
        return pow(x, MOD - 2);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        
        int[] time = new int[n];
        int total = 0;
        
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(br.readLine());
            total += time[i];
        }
        
        int gap = t - total + 1;
        long result = 1;
        int used = 0;
        
        for (int i = 0; i < n; i++) {
            int remain = n - i;
            result = result * (used + gap + remain) % MOD;
            used += time[i];
        }
        
        result = result * gap % MOD;
        result = result * inv(gap + n) % MOD;
        
        System.out.println(result);
    }
}
