import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        long ans = ((n + 3) * (n + 3) + 6) / 12;
        System.out.println(ans % 1_000_000);
    }
}
