public class MSG {

    static final String DEPTS_TITLE = "Departments List:\n";

    static final String EXIT_TEXT = "\nYou have exited from the CLI.\n";

    static final String LOGIN_PAGE_TITLE = "\n\t\tLOGIN PAGE";

    static final String ADMIN_PANEL_TITLE = "\n\t\tADMIN PANEL\n";

    static final String STUDENT_PANEL_TITLE = "\n\t\tSTUDENT PANEL";

    static final String STUDENT_TITLE_TEXT = "Students List:\n";

    static final String BACK_LOGIN_PROMPT_TEXT =
            "\nEnter \"back\" for back to the previous page" +
                    "\nEnter \"login\" for go to the login page\n>>> ";

    static final String DEPTS_SELECT_TEXT =
            "\nEnter (department name) to display department courses" +
                    BACK_LOGIN_PROMPT_TEXT;

    static final String STUDENT_COURSES_LIST =
            "\nEnter (course code) to unenroll the course" +
                    BACK_LOGIN_PROMPT_TEXT;

    static final String ADMIN_MANAGE_STUDENTS_TEXT =
            "\nEnter (student no) to remove the student from the course" +
                    "\nEnter \"add\" to add a student to the course" +
                    BACK_LOGIN_PROMPT_TEXT;

    static final String STUDENT_MANAGE_COURSES =
            "\nEnter \"list\" to display department lists" +
                    "\nEnter \"enroll\" for the list of enrolled courses" +
                    BACK_LOGIN_PROMPT_TEXT;

    static final String LOGIN_PAGE_TEXT =
            "\nEnter \"admin\" for admin login" +
                    "\nEnter (student number) for student login" +
                    "\nEnter \"exit\" to exit from the system\n>>> ";

    static final String ADMIN_MANAGE_COURSES_TEXT =
            "\nEnter (course code) to display course students" +
                    "\nEnter \"add\" to add a course to the department" +
                    "\nEnter \"delete\" to remove the course from the department" +
                    "\nEnter \"increase\" to increase the capacity of the course" +
                    BACK_LOGIN_PROMPT_TEXT;

    static final String COURSE_TITLE_TEXT =
            "faculty name  " + "  course name  " + "  course code    " +
                    "capacity  " + "  unit  " + "    class time    " + "        exam time" +
                    "      SP/GN\n============    ===========    ===========    " +
                    "========    ====      ==========            =========      =====\n";
}
