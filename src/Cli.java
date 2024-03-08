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
        while(true) {
            switch(cliState) {
                case 0:
                    loginPage();
                    break;
                case 1:
                case 6:
                    userSelectDepts();
                    break;
                case 2:
                    adminManageCourses();
                    break;
                case 3:
                    adminManageStudents();
                    break;
                case 4:
                    studentManageCourses();
                    break;
                case 5:
                    studentCoursesList();
                    break;
                case 7:
                    studentDeptCourses();
            }
        }
    }

    private void loginPage(){
        System.out.print(MSG.LOGIN_PAGE_TEXT);
    }

    private void userSelectDepts() {
        if (cliState == 1) System.out.print(MSG.ADMIN_PANEL_TITLE);
        else System.out.print(MSG.STUDENT_PANEL_TITLE);
    }

    private void adminManageCourses() {
        System.out.print(MSG.ADMIN_PANEL_TITLE);
        System.out.print(MSG.COURSE_TITLE_TEXT);
        System.out.print(MSG.ADMIN_MANAGE_COURSES_TEXT);
    }

    private void adminManageStudents() {
        System.out.print(MSG.ADMIN_PANEL_TITLE);
        System.out.print(MSG.STUDENT_TITLE_TEXT);
        System.out.print(MSG.ADMIN_MANAGE_STUDENTS_TEXT);
    }

    private void studentManageCourses(){
        System.out.print(MSG.STUDENT_MANAGE_COURSES);
    }

    private void studentCoursesList() {
        System.out.print(MSG.COURSE_TITLE_TEXT);
        System.out.print(MSG.STUDENT_COURSES_LIST);
    }

    private void studentDeptCourses() {

    }
}
