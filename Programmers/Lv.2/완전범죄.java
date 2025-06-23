import java.util.*;

class Solution {
    private Map<String, Integer> memo;
    
    public int solution(int[][] info, int n, int m) {
        memo = new HashMap<>();
        int result = dp(info, 0, 0, 0, n, m);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private int dp(int[][] info, int idx, int aTraces, int bTraces, int n, int m) {
        if (idx == info.length) {
            return aTraces;
        }
        if (aTraces >= n || bTraces >= m) {
            return Integer.MAX_VALUE;
        }
        String key = idx + "," + aTraces + "," + bTraces;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int result = Integer.MAX_VALUE;
        for (int traces = 1; traces <= 3; traces++) {
            int newATraces = aTraces + info[idx][0] * traces;
            if (newATraces < n) {
                int subResult = dp(info, idx + 1, newATraces, bTraces, n, m);
                if (subResult != Integer.MAX_VALUE) {
                    result = Math.min(result, subResult);
                }
            }
        }
        for (int traces = 1; traces <= 3; traces++) {
            int newBTraces = bTraces + info[idx][1] * traces;
            if (newBTraces < m) {
                int subResult = dp(info, idx + 1, aTraces, newBTraces, n, m);
                if (subResult != Integer.MAX_VALUE) {
                    result = Math.min(result, subResult);
                }
            }
        }
        memo.put(key, result);
        return result;
    }
}
