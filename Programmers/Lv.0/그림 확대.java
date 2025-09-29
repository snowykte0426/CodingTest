class Solution {
    public String[] solution(String[] picture, int k) {
        int originalHeight = picture.length;
        int originalWidth = picture[0].length();
        String[] answer = new String[originalHeight * k];
        int answerIndex = 0;
        for (String s : picture) {
            StringBuilder expandedRow = new StringBuilder();
            for (int j = 0; j < originalWidth; j++) {
                char pixel = s.charAt(j);
                expandedRow.append(String.valueOf(pixel).repeat(Math.max(0, k)));
            }
            String expandedRowString = expandedRow.toString();
            for (int m = 0; m < k; m++) {
                answer[answerIndex++] = expandedRowString;
            }
        }

        return answer;
    }
}
