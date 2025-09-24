import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        for (int i = 0; i < query.length; i++) {
            int queryValue = query[i];
            if (arr.length == 0 || queryValue >= arr.length) continue;
            if (i % 2 == 0) arr = Arrays.copyOfRange(arr, 0, queryValue + 1);
            else arr = Arrays.copyOfRange(arr, queryValue, arr.length);
        }
        return arr;
    }
}
