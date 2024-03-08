public class Main {

    public static void main(String[] args) {
        Department math_dept = new Department("Mathematics");
        Department phys_dept = new Department("Physics");
        Department chem_dept = new Department("Chemistry");
        Department comp_dept = new Department("Computer Eng.");

        University university = new University();
        university.addDept(math_dept);
        university.addDept(phys_dept);
        university.addDept(chem_dept);
        university.addDept(comp_dept);

        SpecializedCourse math_sp1 = new SpecializedCourse("Boomari", "Advanced Prog.",
                "22815", 120, 4, "SAT MON 13:00-15:00", "1403/03/26 15:30");
        math_dept.addCourse(math_sp1);
        SpecializedCourse math_sp2 = new SpecializedCourse("Ardashir", "Basics of Math.",
                "22142", 70, 4, "SUN TUE 10:30-12:30", "1403/03/22 09:00");
        math_dept.addCourse(math_sp2);
        GeneralCourse math_gn1 = new GeneralCourse("Chatrchi", "Islamic Thought(1)",
                "37445", 44, 2, "SAT 10:30-12:30", "1403/04/02 13:30");
        math_dept.addCourse(math_gn1);

        SpecializedCourse phys_sp1 = new SpecializedCourse("Khosravi", "Cosmology",
                "24922", 35, 3, "SAT MON 9:00-10:30", "1403/03/30 15:30");
        phys_dept.addCourse(phys_sp1);
        SpecializedCourse phys_sp2 = new SpecializedCourse("Abolhasani", "Relativity",
                "24144", 47, 3, "SAT MON 16:30-18:00", "1403/03/21 15:30");
        phys_dept.addCourse(phys_sp2);
        GeneralCourse phys_gn1 = new GeneralCourse("Mir", "Islamic Thought(2)",
                "37446", 49, 2, "MON 10:30-12:30", "1403/03/29 13:30");
        phys_dept.addCourse(phys_gn1);

        SpecializedCourse chem_sp1 = new SpecializedCourse("Hazrati", "Organic Chem.",
                "23327", 50, 3, "SAT MON 9:00-10:30", "1403/03/20 15:30");
        chem_dept.addCourse(chem_sp1);
        SpecializedCourse chem_sp2 = new SpecializedCourse("Setayesh", "Physical Chemistry",
                "23421", 40, 3, "SAT MON 7:30-9:00", "1403/03/23 9:00");
        chem_dept.addCourse(chem_sp2);
        GeneralCourse chem_gn1 = new GeneralCourse("Jahazi", "Life Style",
                "37127", 42, 2, "SAT 15:00-17:00", "1403/03/21 13:30");
        chem_dept.addCourse(chem_gn1);

        SpecializedCourse comp_sp1 = new SpecializedCourse("Hesabi", "Logic Circuits",
                "40212", 92, 3, "SUN TUE 9:00-10:30", "1403/03/24 15:30");
        comp_dept.addCourse(comp_sp1);
        SpecializedCourse comp_sp2 = new SpecializedCourse("Jalili", "Operating Systems",
                "40424", 50, 3, "SUN TUE 15:00-16:30", "1403/03/31 15:30");
        comp_dept.addCourse(comp_sp2);
        GeneralCourse comp_gn1 = new GeneralCourse("Gerami", "History of Imamate",
                "37622", 49, 2, "SAT 13:00-15:00", "1403/04/03 13:30");
        comp_dept.addCourse(comp_gn1);

        Cli cli = new Cli(university);
        cli.runCli();
    }
}
