import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = nums.length / 2;
        int types = set.size();
        return Math.min(max, types);
    }
}
