import java.util.HashMap;

class Solution {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> score = new HashMap<>();
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        for (char type : types) {
            score.put(type, 0);
        }
        for (int i = 0; i < survey.length; i++) {
            char disagree = survey[i].charAt(0);
            char agree = survey[i].charAt(1);
            int choice = choices[i];
            if (choice < 4) {
                int point = 4 - choice;
                score.put(disagree, score.get(disagree) + point);
            } else if (choice > 4) {
                int point = choice - 4;
                score.put(agree, score.get(agree) + point);
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(score.get('R') >= score.get('T') ? 'R' : 'T');
        answer.append(score.get('C') >= score.get('F') ? 'C' : 'F');
        answer.append(score.get('J') >= score.get('M') ? 'J' : 'M');
        answer.append(score.get('A') >= score.get('N') ? 'A' : 'N');
        return answer.toString();
    }
}
