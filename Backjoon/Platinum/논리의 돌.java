import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        
        ans.add("17 16 16");
        
        for (int i = 1; i <= 15; i++) {
            for (int j = 1; j < i; j++) {
                ans.add("16 " + j + " " + i);
                ans.add("-" + i + " -" + j + " -" + i);
                ans.add(j + " 16 16");
            }
        }
        
        ans.add("16 17 17");
        
        for (int i = 16; i >= 2; i--) {
            ans.add("17 " + (i - 1) + " " + i);
            ans.add("-" + i + " -" + (i - 1) + " -" + i);
            ans.add((i - 1) + " 17 17");
        }
        
        System.out.println(ans.size());
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
