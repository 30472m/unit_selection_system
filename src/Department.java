import java.util.ArrayList;

public class Department {

    private final String deptName;
    private final ArrayList<Course> courses;

    public Department(String dp_name) {
        this.deptName = dp_name;
        this.courses = new ArrayList<>();
    }

    public void showDeptCourses() {
        for (Course crs : this.getCourses())
            System.out.println(crs);
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
