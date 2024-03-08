import java.util.ArrayList;

public class University {
    private final ArrayList<Student> students;
    private final ArrayList<Department> departments;

    public University() {
        this.students = new ArrayList<>();
        this.departments = new ArrayList<>();
    }

    public void addDept(Department dep) {
        departments.add(dep);
    }

    public void showDepts() {
        System.out.print(MSG.DEPTS_TITLE);
        for (Department dept : departments)
            System.out.println(dept);
        System.out.print(MSG.DEPTS_SELECT_TEXT);
    }

    public void showCourseStudents(Course crs) {

    }

    public void showStudCourses(Student stud) {

    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
