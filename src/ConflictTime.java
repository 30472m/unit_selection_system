import java.util.ArrayList;

public class ConflictTime {

    public static boolean crsExamTimeConflict(Course crs1, Course crs2) {
        return crs1.getExamTime().equals(crs2.getExamTime());
    }

    public static boolean crsClassTimeConflict(Course crs1, Course crs2) {
        ArrayList<Integer> listCrs1 = convertClassTime(crs1.getClassTime());
        ArrayList<Integer> listCrs2 = convertClassTime(crs2.getClassTime());
        for (Integer val : listCrs1)
            if (listCrs2.contains(val))
                return true;
        return false;
    }

    private static ArrayList<Integer> convertClassTime(String clsTime) {
        String[] split = clsTime.split(" ");
        String time = split[split.length - 1];
        int startTime = findInterval(time, 0, time.indexOf(':'),
                time.indexOf(':')+1, time.indexOf('-'));
        int endTime = findInterval(split[split.length-1], time.indexOf('-')+1,
                time.indexOf(':', 5), time.indexOf(':', 5)+1, time.length());

        ArrayList<Integer> intervals = new ArrayList<>();
        for (int i = startTime; i < endTime; i++) {
            intervals.add(findWeekDay(split[0])*48 + i);
            if (split.length == 4)
                intervals.add(findWeekDay(split[1])*48 + i);
        }
        return intervals;
    }

    private static int findInterval(String str, int a, int b, int c, int d) {
        return Integer.parseInt(str.substring(a, b))*2
                + Integer.parseInt(str.substring(c, d))/30;
    }

    private static int findWeekDay(String day) {
        String[] weekDays = {"SAT", "SUN", "MON", "TUE", "WED", "THR", "FRI"};
        for (int idx = 0; idx < 7; idx++)
            if (day.equals(weekDays[idx])) return idx;
        return -1;
    }
}
