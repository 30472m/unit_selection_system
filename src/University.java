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

    public Department findDepartment(String deptName) {
        for (Department dept : departments)
            if (deptName.equals(dept.getDeptName()))
                return dept;
        return null;
    }

    public Student findOrAddStudent(String studNum) {
        if (studNum == null || !Student.checkStudNumFormat(studNum))
            return null;
        for (Student stud : students)
            if (studNum.equals(stud.getStudentNum()))
                return stud;
        Student new_student = new Student(studNum);
        students.add(new_student);
        return new_student;
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
