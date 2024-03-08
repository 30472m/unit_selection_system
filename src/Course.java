import java.util.regex.*;

public class Course {
    private final String facultyName;
    private final String courseName;
    private final String courseCode;
    private int capacity;
    private final int unit;
    private final String classTime;
    private final String examTime;

    public Course(String fac_name, String crs_name, String crs_code,
                  int cap, int crdt, String cls_time, String ex_time) {
        this.facultyName = fac_name;
        this.courseName = crs_name;
        this.courseCode = crs_code;
        this.capacity = cap;
        this.unit = crdt;
        this.classTime = cls_time;
        this.examTime = ex_time;
    }

    public static boolean checkCourseCodeFormat(String inp) {
        String regex = "^[1-5][0-9]{4}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inp);
        return m.matches();
    }


    public String getCourseCode() {
        return courseCode;
    }

    public int getUnit() {
        return unit;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int cap) {
        this.capacity = cap;
    }

    public String getClassTime() {
        return classTime;
    }

    public String getExamTime() {
        return examTime;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s%-14s%-10d%-6d%-22s%-20s", facultyName,
                courseName, courseCode, capacity, unit, classTime, examTime);
    }
}

