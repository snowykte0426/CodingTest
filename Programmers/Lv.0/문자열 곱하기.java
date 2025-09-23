class Solution {
    public String solution(String my_string, int k) {
        return String.valueOf(my_string).repeat(Math.max(0, k));
    }
}
