import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        List<Integer> answer = new ArrayList<>();
        for (int num : arr) {
            if (answer.size() >= k) break;
            if (set.add(num)) {
                answer.add(num);
            }
        }
        while (answer.size() < k) {
            answer.add(-1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
