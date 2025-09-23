import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> answer = new ArrayList<>();

    public int[] solution(int[] num_list) {
        for (int j : num_list) {
            answer.add(j);
        }
        if (num_list[num_list.length - 1] <= num_list[num_list.length - 2]) {
            answer.add(num_list[num_list.length - 1] * 2);
        } else {
            answer.add(num_list[num_list.length - 1] - num_list[num_list.length - 2]);
        }
        int[] ans = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}
