import java.util.Scanner;

public class Cli {
    private int cliState;
    private final Scanner sc;
    private String inputCommand;
    private final University university;

    public Cli(University univ) {
        this.cliState = 0;
        this.university = univ;
        this.sc = new Scanner(System.in);
    }

    public void runCli() {
        Course crs = null;
        Student stud = null;
        Department dept = null;
        while(true) {
            switch(cliState) {
                case 0:
                    stud = loginPage();
                    break;
                case 1:
                case 6:
                    dept = userSelectDepts();
                    break;
                case 2:
                    crs = adminManageCourses(dept);
                    break;
                case 3:
                    adminManageStudents(crs);
                    break;
                case 4:
                    studentManageCourses();
                    break;
                case 5:
                    studentCoursesList(stud);
                    break;
                case 7:
                    studentDeptCourses(stud, dept);
            }
        }
    }

    private Student loginPage(){
        System.out.print(MSG.LOGIN_PAGE_TEXT);
        return null;
    }

    private Department userSelectDepts() {
        if (cliState == 1) System.out.print(MSG.ADMIN_PANEL_TITLE);
        else System.out.print(MSG.STUDENT_PANEL_TITLE);
        return null;
    }

    private Course adminManageCourses(Department dept) {
        System.out.print(MSG.ADMIN_PANEL_TITLE);
        System.out.print(MSG.COURSE_TITLE_TEXT);
        System.out.print(MSG.ADMIN_MANAGE_COURSES_TEXT);
        return null;
    }

    private void adminManageStudents(Course crs) {
        System.out.print(MSG.ADMIN_PANEL_TITLE);
        System.out.print(MSG.STUDENT_TITLE_TEXT);
        System.out.print(MSG.ADMIN_MANAGE_STUDENTS_TEXT);
    }

    private void studentManageCourses(){
        System.out.print(MSG.STUDENT_MANAGE_COURSES);
    }

    private void studentCoursesList(Student stud) {
        System.out.print(MSG.COURSE_TITLE_TEXT);
        System.out.print(MSG.STUDENT_COURSES_LIST);
    }

    private void studentDeptCourses(Student stud, Department dept) {

    }

    private void terminateCli() {
        System.out.print(MSG.EXIT_TEXT);
        System.exit(0);
    }
}
