import java.util.ArrayList;

public class University {
    private final Enrollments allEnrollments;
    private final ArrayList<Student> students;
    private final ArrayList<Department> departments;

    public University() {
        this.students = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.allEnrollments = new Enrollments();
    }

    public void addDept(Department dep) {
        departments.add(dep);
    }

    public void showDepts() {
        for (Department dept : departments)
            System.out.println(dept);
    }

    public Department findDepartment(String deptName) {
        for (Department dept : departments)
            if (deptName.equals(dept.getDeptName()))
                return dept;
        return null;
    }

    public Student findStudent(String studNum) {
        for (Student stud : students)
            if (studNum.equals(stud.getStudentNum()))
                return stud;
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

    public Course findCourse(String crsCode) {
        for (Department dept : departments)
            for (Course course : dept.getCourses())
                if (crsCode.equals(course.getCourseCode()))
                    return course;
        return null;
    }

    public void showCourseStudents(Course crs) {
        if (!allEnrollments.showCourseStudents(crs))
            System.out.println("\tNo students have enrolled in this course.");
    }

    public void showStudCourses(Student stud) {
        allEnrollments.showStudentCourses(stud);
    }

    public void unEnrollment(Student stud, Course crs) {
        allEnrollments.deleteStudentCourseEnroll(stud, crs);
    }

    public void enrollStudent(String stNum, Course crs) {
        Student stud = findOrAddStudent(stNum);
        if (stud != null)
            allEnrollments.enrollStudent(stud, crs);
    }

    public void enrollStudent(Student stud, Course crs) {
        allEnrollments.enrollStudent(stud, crs);
    }

    public Enrollments getAllEnrollments() {
        return allEnrollments;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
