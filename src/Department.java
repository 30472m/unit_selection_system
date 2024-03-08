import java.util.ArrayList;

public class Department {

    private final String deptName;
    private final ArrayList<Course> courses;

    public Department(String dp_name) {
        this.deptName = dp_name;
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course crs) {
        if (crs != null)
            courses.add(crs);
    }

    public void delCrs(String crsCode, Enrollments enrs) {
        if (crsCode != null) {
            Course crs = findCourse(crsCode);
            if (crs != null) {
                enrs.deleteAllCrsEnroll(crs);
                courses.remove(crs);
            }
        }
    }

    public Course findCourse(String crsCode) {
        for (Course crs : this.courses)
            if (crsCode.equals(crs.getCourseCode()))
                return crs;
        return null;
    }

    public void showDeptCourses() {
        for (Course crs : this.getCourses())
            System.out.println(crs);
    }

    public void increaseCapacity(String crsCodeAndIncVal) {
        if (crsCodeAndIncVal != null) {
            String[] params = crsCodeAndIncVal.split(",");
            Course crs = findCourse(params[0]);
            int incVal = Integer.parseInt(params[1]);
            if (incVal > 0)
                crs.setCapacity(crs.getCapacity() + incVal);
        }
    }

    public String getDeptName() {
        return deptName;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "   - " + getDeptName();
    }
}
