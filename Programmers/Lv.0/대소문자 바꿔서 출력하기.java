import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        for (char c : a.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                System.out.print(AsciiPlus.toUpper(c));
            } else {
                System.out.print(AsciiPlus.toLower(c));
            }
        }
    }
}

class AsciiPlus {
    public static char toLower(char ch) {
        if (ch >= 'A' && ch <= 'Z') {
            return (char) (ch + 32);
        }
        return ch;
    }

    public static char toUpper(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return (char) (ch - 32);
        }
        return ch;
    }
}
