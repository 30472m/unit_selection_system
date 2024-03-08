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

    }

    private void userSelectDepts() {

    }

    private void adminManageCourses() {

    }

    private void adminManageStudents() {

    }

    private void studentManageCourses(){

    }

    private void studentCoursesList() {

    }

    private void studentDeptCourses() {
        
    }
}
