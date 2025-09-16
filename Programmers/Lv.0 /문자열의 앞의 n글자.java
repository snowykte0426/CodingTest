class Solution {
    public String solution(String my_string, int n) {
        return my_string.split(String.valueOf(my_string.charAt(n)))[0];
    }
}
