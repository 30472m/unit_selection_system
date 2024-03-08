import java.util.Scanner;

public class InputInfo {

    public static Course inputNewCourseInfo() {
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

    public static String inputCrsCodeForDel() {
        return testInputCancel("Enter course code: ");
    }

    public static String inputCrsCodeAndCapForIncCap() {
        String crsCode = testInputCancel("Enter course code: ");
        if (crsCode == null) return null;
        String incValue = testInputCancel("Enter the capacity increase value: ");
        if (incValue == null) return null;
        return crsCode + "," + incValue;
    }


    public static String inputStudNumberForEnroll() {
        return testInputCancel("Enter student number: ");
    }

    private static String testInputCancel(String text) {
        System.out.print(text);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if ("cancel".equals(input))
            return null;
        else
            return input;
    }
}
