class Solution {
    public String solution(String code) {
        StringBuilder result = new StringBuilder();
        Mode mode = Mode.MODE0;
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                mode = mode.reverse();
                continue;
            }
            if (mode == Mode.MODE0) {
                if (i % 2 == 0) result.append(code.charAt(i));
            } else {
                if (i % 2 == 1) result.append(code.charAt(i));
            }
        }
        return result.toString().equals("") ? "EMPTY" : result.toString();
    }
}

enum Mode {
    MODE1, MODE0;

    public Mode reverse() {
        return (this == MODE1) ? MODE0 : MODE1;
    }
}
