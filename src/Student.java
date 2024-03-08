import java.util.regex.*;

public class Student {
    private final String studentNum;
    private int numOfGnUnits;
    private int numOfUnits;

    public Student(String st_num) {
        this.studentNum = st_num;
        this.numOfGnUnits = 0;
        this.numOfUnits = 0;
    }

    public static boolean checkStudNumFormat(String inp) {
        String regex = "^[1-9][0-9]{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(inp);
        return m.matches();
    }

    public String getStudentNum() {
        return studentNum;
    }

    public int getNumOfUnits() {
        return numOfUnits;
    }

    public void setNumOfUnits(int units) {
        this.numOfUnits = units;
    }

    public int getNumOfGnUnits() {
        return numOfGnUnits;
    }

    public void setNumOfGnUnits(int gnUnits) {
        this.numOfGnUnits = gnUnits;
    }

    @Override
    public String toString() {
        return "   ----: " + getStudentNum();
    }
}
