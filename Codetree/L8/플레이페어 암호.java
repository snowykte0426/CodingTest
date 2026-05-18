import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine().trim();
        String key = br.readLine().trim();

        char[][] table = new char[5][5];
        int[] row = new int[26];
        int[] col = new int[26];
        boolean[] used = new boolean[26];
        int idx = 0;

        for (char c : (key + "ABCDEFGHIKLMNOPQRSTUVWXYZ").toCharArray()) {
            if (c == 'J' || used[c - 'A']) continue;
            used[c - 'A'] = true;
            table[idx / 5][idx % 5] = c;
            row[c - 'A'] = idx / 5;
            col[c - 'A'] = idx % 5;
            idx++;
        }

        StringBuilder pairs = new StringBuilder();
        int i = 0;
        while (i < msg.length()) {
            char a = msg.charAt(i);
            if (i + 1 == msg.length()) {
                pairs.append(a).append('X');
                i++;
            } else {
                char b = msg.charAt(i + 1);
                if (a == b) {
                    char ins = (a == 'X') ? 'Q' : 'X';
                    pairs.append(a).append(ins);
                    i++;
                } else {
                    pairs.append(a).append(b);
                    i += 2;
                }
            }
        }

        StringBuilder out = new StringBuilder();
        for (int k = 0; k < pairs.length(); k += 2) {
            char a = pairs.charAt(k), b = pairs.charAt(k + 1);
            int ra = row[a - 'A'], ca = col[a - 'A'];
            int rb = row[b - 'A'], cb = col[b - 'A'];
            if (ra == rb) {
                out.append(table[ra][(ca + 1) % 5]);
                out.append(table[rb][(cb + 1) % 5]);
            } else if (ca == cb) {
                out.append(table[(ra + 1) % 5][ca]);
                out.append(table[(rb + 1) % 5][cb]);
            } else {
                out.append(table[ra][cb]);
                out.append(table[rb][ca]);
            }
        }
        System.out.println(out);
    }
}
