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

    private Student loginPage() {
        Student stud;
        System.out.print(MSG.LOGIN_PAGE_TEXT);
        inputCommand = sc.nextLine();
        if ((stud = university.findOrAddStudent(inputCommand)) != null)
            cliState = 4;
        else if ("admin".equals(inputCommand))
            cliState = 1;
        else if ("exit".equals(inputCommand))
            terminateCli();
        return stud;
    }

    private Department userSelectDepts() {
        if (cliState == 1) System.out.print(MSG.ADMIN_PANEL_TITLE);
        else System.out.print(MSG.STUDENT_PANEL_TITLE);

        Department dept;
        university.showDepts();
        inputCommand = sc.nextLine();
        if ((dept = university.findDepartment(inputCommand)) != null)
            cliState = (cliState == 1) ? 2 : 7;
        backOrLoginCommand(inputCommand);
        return dept;
    }

    private Course adminManageCourses(Department dept) {
        Course crs;
        System.out.print(MSG.ADMIN_PANEL_TITLE);
        System.out.print(MSG.COURSE_TITLE_TEXT);
        dept.showDeptCourses();
        System.out.print(MSG.ADMIN_MANAGE_COURSES_TEXT);
        inputCommand = sc.nextLine();

        if ((crs = dept.findCourse(inputCommand)) != null)
            cliState = 3;
        else if ("add".equals(inputCommand))
            dept.addCourse(inputNewCourseInfo());
        else if ("delete".equals(inputCommand))
            dept.deleteCourse(inputCourseCodeForDelete());
        backOrLoginCommand(inputCommand);
        return crs;
    }

    private void adminManageStudents(Course crs) {
        Student stud;
        System.out.print(MSG.ADMIN_PANEL_TITLE);
        System.out.print(MSG.STUDENT_TITLE_TEXT);
        university.showCourseStudents(crs);
        System.out.print(MSG.ADMIN_MANAGE_STUDENTS_TEXT);
        inputCommand = sc.nextLine();

        if ((stud = university.findStudent(inputCommand)) != null)
            university.unEnrollment(stud, crs);
        else if ("add".equals(inputCommand))
            university.enrollStudent(inputStudNumberForEnroll(), crs);
        backOrLoginCommand(inputCommand);
    }

    private void studentManageCourses() {
        System.out.print(MSG.STUDENT_MANAGE_COURSES);
        inputCommand = sc.nextLine();
        if ("enroll".equals(inputCommand))
            cliState = 5;
        else if ("list".equals(inputCommand))
            cliState = 6;
        backOrLoginCommand(inputCommand);
    }

    private void studentCoursesList(Student stud) {
        Course crs;
        System.out.print(MSG.COURSE_TITLE_TEXT);
        university.showStudCourses(stud);
        System.out.print(MSG.STUDENT_COURSES_LIST);
        inputCommand = sc.nextLine();
        if ((crs = university.findCourse(inputCommand)) != null)
            university.unEnrollment(stud, crs);
        backOrLoginCommand(inputCommand);
    }

    private void studentDeptCourses(Student stud, Department dept) {
        Course crs;
        dept.showDeptCourses();
        inputCommand = sc.nextLine();
        if ((crs = university.findCourse(inputCommand)) != null)
            university.enrollStudent(stud, crs);
        backOrLoginCommand(inputCommand);
    }

    private boolean backOrLoginCommand(String command) {
        boolean flag = false;
        if (null != command) switch (command) {
            case "back":
                cliState = (cliState == 4) ? 0 : (cliState - 1);
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

    private Course inputNewCourseInfo() {
        Course crs = null;
        String facultyName = testInputCancel("Enter faculty name: ");
        if (facultyName == null) return null;
        String courseName = testInputCancel("Enter course name: ");
        if (courseName == null) return null;
        String courseCode = testInputCancel("Enter course code: ");
        if (courseCode == null) return null;
        String capacity = testInputCancel("Enter capacity: ");
        if (capacity == null) return null;
        String unit = testInputCancel("Enter unit: ");
        if (unit == null) return null;
        String classTime = testInputCancel("Enter classTime: ");
        if (classTime == null) return null;
        String examTime = testInputCancel("Enter examTime: ");
        if (examTime == null) return null;
        String courseType = testInputCancel("Enter course type (SP/GN): ");
        if (courseType == null) return null;

        if ("SP".equals(courseType))
            crs = new SpecializedCourse(facultyName, courseName, courseCode,
                    Integer.parseInt(capacity), Integer.parseInt(unit),
                    classTime, examTime);
        else if ("GN".equals(courseType))
            crs = new GeneralCourse(facultyName, courseName, courseCode,
                    Integer.parseInt(capacity), Integer.parseInt(unit),
                    classTime, examTime);
        return crs;
    }

    private String inputCourseCodeForDelete() {
        return testInputCancel("Enter course code: ");
    }

    private String inputStudNumberForEnroll() {
        return testInputCancel("Enter student number: ");
    }

    private String testInputCancel(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if ("cancel".equals(input))
            return null;
        else
            return input;
    }
}
