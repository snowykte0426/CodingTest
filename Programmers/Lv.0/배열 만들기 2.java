class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {};
        for (int i = l; i <= r; i++) {
            String s = String.valueOf(i);
            boolean valid = true;
            for (char c : s.toCharArray()) {
                if (c != '0' && c != '5') {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                int[] newAnswer = new int[answer.length + 1];
                System.arraycopy(answer, 0, newAnswer, 0, answer.length);
                newAnswer[answer.length] = i;
                answer = newAnswer;
            }
        }
        if (answer.length == 0) {
            answer = new int[]{-1};
        }
        return answer;
    }
}
