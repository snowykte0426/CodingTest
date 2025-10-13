import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;

class Solution {
    
    private static final int YEAR = 2016;
    
    public String solution(int a, int b) {
        LocalDate date = LocalDate.of(YEAR, a, b);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase();
    }
}
