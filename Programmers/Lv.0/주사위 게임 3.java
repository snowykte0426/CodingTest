import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] arr = {a, b, c, d};
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        if (map.size() == 1) {
            return 1111 * a;
        }
        if (map.size() == 2) {
            for (int key : map.keySet()) {
                if (map.get(key) == 3) {
                    int q = 0;
                    for (int k : map.keySet()) {
                        if (map.get(k) == 1) q = k;
                    }
                    return (int) Math.pow(10 * key + q, 2);
                }
            }
            int[] keys = new int[2];
            int idx = 0;
            for (int key : map.keySet()) {
                keys[idx++] = key;
            }
            return (keys[0] + keys[1]) * Math.abs(keys[0] - keys[1]);
        }
        if (map.size() == 3) {
            int p = 0, q = 0;
            for (int key : map.keySet()) {
                if (map.get(key) == 2) p = key;
            }
            int[] single = new int[2];
            int idx = 0;
            for (int key : map.keySet()) {
                if (map.get(key) == 1) single[idx++] = key;
            }
            return single[0] * single[1];
        }
        int min = a;
        min = Math.min(min, b);
        min = Math.min(min, c);
        min = Math.min(min, d);
        return min;
    }
}
