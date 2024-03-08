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
        while(true)
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

    private Student loginPage() {
        Student stud;
        System.out.print(MSG.LOGIN_PAGE_TITLE + MSG.LOGIN_PAGE_TEXT);
        inputCommand = sc.nextLine();
        if ((stud = university.findOrAddStudent(inputCommand)) != null)
            cliState = 4;
        else if ("admin".equals(inputCommand))
            cliState = 1;
        else if ("exit".equals(inputCommand))
            terminateCli();
        else
            LogicalError.errorLoginPage();
        return stud;
    }

    private Department userSelectDepts() {
        Department dept;
        if (cliState == 1)
            System.out.print(MSG.ADMIN_PANEL_TITLE + MSG.DEPTS_TITLE);
        else
            System.out.print(MSG.STUDENT_PANEL_TITLE + MSG.DEPTS_TITLE);
        university.showDepts();
        System.out.print(MSG.DEPTS_SELECT_TEXT);
        inputCommand = sc.nextLine();
        if ((dept = university.findDepartment(inputCommand)) != null)
            cliState = (cliState == 1) ? 2 : 7;
        else if (!backOrLoginCommand(inputCommand))
            LogicalError.errorUserSelectDepts();
        return dept;
    }

    private Course adminManageCourses(Department dept) {
        Course crs;
        System.out.print(MSG.ADMIN_PANEL_TITLE + MSG.COURSE_TITLE_TEXT);
        dept.showDeptCourses();
        System.out.print(MSG.ADMIN_MANAGE_COURSES_TEXT);
        inputCommand = sc.nextLine();
        if ((crs = dept.findCourse(inputCommand)) != null)
            cliState = 3;
        else if ("add".equals(inputCommand))
            dept.addCourse(InputInfo.inputNewCourseInfo());
        else if ("delete".equals(inputCommand))
            dept.deleteCourse(InputInfo.inputCrsCodeForDel(),
                    university.getAllEnrollments());
        else if ("increase".equals(inputCommand))
            dept.increaseCapacity(InputInfo.inputCrsCodeAndCapForIncCap());
        else if (!backOrLoginCommand(inputCommand))
            LogicalError.errorAdminManageCourses();
        return crs;
    }

    private void adminManageStudents(Course crs) {
        Student stud;
        System.out.print(MSG.ADMIN_PANEL_TITLE + MSG.STUDENT_TITLE_TEXT);
        university.showCourseStudents(crs);
        System.out.print(MSG.ADMIN_MANAGE_STUDENTS_TEXT);
        inputCommand = sc.nextLine();
        if ((stud = university.findStudent(inputCommand)) != null)
            university.unEnrollment(stud, crs);
        else if ("add".equals(inputCommand))
            university.enrollStudent(InputInfo.inputStudNumberForEnroll(), crs);
        else if (!backOrLoginCommand(inputCommand))
            LogicalError.errorAdminManageStudents();
    }

    private void studentManageCourses() {
        System.out.print(MSG.STUDENT_PANEL_TITLE + MSG.STUDENT_MANAGE_COURSES);
        inputCommand = sc.nextLine();
        if ("enroll".equals(inputCommand))
            cliState = 5;
        else if ("list".equals(inputCommand))
            cliState = 6;
        else if (!backOrLoginCommand(inputCommand))
            LogicalError.errorStudentManageCourses();
    }

    private void studentCoursesList(Student stud) {
        Course crs;
        System.out.print(MSG.STUDENT_PANEL_TITLE + MSG.COURSE_TITLE_TEXT);
        university.showStudCourses(stud);
        System.out.print(MSG.STUDENT_COURSES_LIST);
        inputCommand = sc.nextLine();
        if ((crs = university.findCourse(inputCommand)) != null)
            university.unEnrollment(stud, crs);
        else if (!backOrLoginCommand(inputCommand))
            LogicalError.errorStudentCoursesList();
    }

    private void studentDeptCourses(Student stud, Department dept) {
        Course crs;
        System.out.print(MSG.STUDENT_PANEL_TITLE + MSG.COURSE_TITLE_TEXT);
        dept.showDeptCourses();
        System.out.print(MSG.STUDENT_COURSES_LIST);
        inputCommand = sc.nextLine();
        if ((crs = university.findCourse(inputCommand)) != null)
            university.enrollStudent(stud, crs);
        else if (!backOrLoginCommand(inputCommand))
            LogicalError.errorStudentDeptCourses();
    }

    private boolean backOrLoginCommand(String command) {
        boolean flag = false;
        if (null != command) switch (command) {
            case "back":
                if (cliState == 6) cliState = 4;
                else cliState = (cliState == 4) ? 0 : (cliState - 1);
                flag = true;
                break;
            case "login":
                cliState = 0;
                flag = true;
        }
        return flag;
    }

    private void terminateCli() {
        System.out.print(MSG.EXIT_TEXT);
        System.exit(0);
    }
}
