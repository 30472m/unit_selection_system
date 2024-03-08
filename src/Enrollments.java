import java.util.ArrayList;

public class Enrollments {
    private final ArrayList<Enroll> allEnrolls;

    class Enroll {
        final Student student;
        final Course course;

        public Enroll(Student stud, Course course) {
            this.student = stud;
            this.course = course;
        }
    }

    public Enrollments() {
        allEnrolls = new ArrayList<>();
    }

    public boolean showCourseStudents(Course crs) {
        boolean flag = false;
        for (Enroll enr : allEnrolls) {
            if (enr.course.getCourseCode().equals(crs.getCourseCode())) {
                System.out.println(enr.student);
                flag = true;
            }
        }
        return flag;
    }

    public void enrollStudent(Student stud, Course crs) {
        stud.setNumOfUnits(stud.getNumOfUnits() + crs.getUnit());
        if (crs instanceof GeneralCourse)
           stud.setNumOfGnUnits(stud.getNumOfGnUnits() + crs.getUnit());
        allEnrolls.add(new Enroll(stud, crs));
    }

    public void deleteStudentCourseEnroll(Student stud, Course crs) {
        for (Enroll enr : allEnrolls) {
            if (enr.student == stud && enr.course == crs)
                allEnrolls.remove(enr);
            break;
        }
    }
}
