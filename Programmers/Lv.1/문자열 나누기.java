class Solution {
    public int solution(String s) {
        int answer = 0;
        int index = 0;
        while (index < s.length()) {
            char x = s.charAt(index);
            int xCount = 0;
            int otherCount = 0;
            while (index < s.length()) {
                if (s.charAt(index) == x) {
                    xCount++;
                } else {
                    otherCount++;
                }
                index++;
                if (xCount == otherCount) {
                    break;
                }
            }
            answer++;
        }
        return answer;
    }
}
