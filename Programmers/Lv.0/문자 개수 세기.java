class Solution {
    public int[] solution(String my_string) {
        int[] counts = new int[52];
        for (char ch : my_string.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                counts[ch - 'A']++;
            } else if ('a' <= ch && ch <= 'z') {
                counts[ch - 'a' + 26]++;
            }
        }
        return counts;
    }
}
