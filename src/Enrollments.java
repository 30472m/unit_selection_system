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

    public void showStudentCourses(Student stud) {
        for (Enroll enr : allEnrolls) {
            if (enr.student.getStudentNum().equals(stud.getStudentNum()))
                System.out.println(enr.course);
        }
    }

    public void enrollStudent(Student stud, Course crs) {
        if (existStudCrsEnroll(stud, crs))
            LogicalError.errorExistStudCrsEnroll();
        else if (sumOfUnitsGt20(stud, crs))
            LogicalError.errorSumOfUnitsGt20();
        else if (sumOfGnUnitsGt5(stud, crs))
            LogicalError.errorSumOfGnUnitsGt5();
        else {
            stud.setNumOfUnits(stud.getNumOfUnits() + crs.getUnit());
            if (crs instanceof GeneralCourse)
                stud.setNumOfGnUnits(stud.getNumOfGnUnits() + crs.getUnit());
            allEnrolls.add(new Enroll(stud, crs));
        }
    }

    public void deleteStudentCourseEnroll(Student stud, Course crs) {
        for (Enroll enr : allEnrolls) {
            if (enr.student == stud && enr.course == crs)
                allEnrolls.remove(enr);
            break;
        }
    }

    private boolean existStudCrsEnroll(Student stud, Course crs) {
        for (Enroll enr : allEnrolls)
            if (enr.student == stud && enr.course == crs)
                return true;
        return false;
    }

    private boolean sumOfUnitsGt20(Student stud, Course crs) {
        return stud.getNumOfUnits() + crs.getUnit() > 20;
    }

    private boolean sumOfGnUnitsGt5(Student stud, Course crs) {
        return ((crs instanceof GeneralCourse) &&
                (stud.getNumOfGnUnits() + crs.getUnit() > 5));
    }
}
