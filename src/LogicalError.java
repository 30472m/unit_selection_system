public class LogicalError {
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_RESET = "\u001B[0m";

    public static void errorLoginPage() {
        showErrorMsg("Enter exactly the command \"admin\" or \"exit\"");
        showErrorMsg("Or enter a 9-digit student number for login.");
    }

    public static void errorUserSelectDepts() {
        showErrorMsg("Enter the exact name of the department.");
        showErrorMsg("Or enter exactly the command \"back\" or \"login\"");
    }

    public static void errorAdminManageCourses() {
        showErrorMsg("The course code is not in the department course list.");
        showErrorMsg("Enter the correct 5-digit course code");
        showErrorMsg("Or enter exactly the command \"add\" or \"delete\"");
        showErrorMsg("Or \"increase\" or \"back\" or \"login\"");
    }

    public static void errorAdminManageStudents() {
        showErrorMsg("The student doesn't exist or isn't enrolled in this course.");
        showErrorMsg("Enter the correct 9-digit student number");
        showErrorMsg("Or enter exactly the command \"add\" or \"back\" or \"login\"");
    }

    public static void errorStudentManageCourses() {
        showErrorMsg("Enter exactly the command \"list\" or \"enroll\"");
        showErrorMsg("Or enter exactly the command \"back\" or \"login\"");
    }

    public static void errorStudentCoursesList() {
        showErrorMsg("You have not taken this course.");
        showErrorMsg("Enter the 5-digit course code again");
        showErrorMsg("Or enter exactly the command \"back\" or \"login\"");
    }

    public static void errorStudentDeptCourses() {
        showErrorMsg("The course code is not in the department course list.");
        showErrorMsg("Enter the 5-digit course code again");
        showErrorMsg("Or enter exactly the command \"back\" or \"login\"");
    }

    public static void errorExistStudCrsEnroll() {
        showErrorMsg("The student is already enrolled in this course.");
        showErrorMsg("It cannot be taken again.");
    }

    public static void errorSumOfUnitsGt20() {
        showErrorMsg("Sum of course units has increased more than 20 units.");
        showErrorMsg("You cannot take this course.");
    }

    public static void errorSumOfGnUnitsGt5() {
        showErrorMsg("Sum of GN course units has increased more than 5 units.");
        showErrorMsg("You cannot take this course.");
    }

    public static void errorConflictCourseTimeOrExamTime() {
        showErrorMsg("The class/exam time conflicts with your taken courses.");
        showErrorMsg("You cannot take this course.");
    }

    public static void errorCourseCapIsFull() {
        showErrorMsg("The capacity of the course is full.");
        showErrorMsg("You cannot enroll for this course.");
    }

    private static void showErrorMsg(String message) {
        System.out.println(ANSI_RED + message + ANSI_RESET);
    }
}
