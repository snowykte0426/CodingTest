import java.util.Map;

class Solution {
    private final Map<Integer, String> dayMap = Map.of(
        0, "SUN", 1, "MON", 2, "TUE", 3, "WED",
        4, "THU", 5, "FRI", 6, "SAT"
    );

    private int addTenMinutes(int time) {
        int hour = time / 100;
        int minute = time % 100;
        minute += 10;
        if (minute >= 60) {
            hour += 1;
            minute -= 60;
        }
        return hour * 100 + minute;
    }

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            boolean isQualified = true;
            for (int day = 0; day < timelogs[i].length; day++) {
                String dayOfWeek = dayMap.get((startday + day) % 7);
                if (dayOfWeek.equals("SAT") || dayOfWeek.equals("SUN")) continue;
                if (timelogs[i][day] > addTenMinutes(schedules[i])) {
                    isQualified = false;
                    break;
                }
            }
            if (isQualified) {
                answer++;
            }
        }
        return answer;
    }
}
