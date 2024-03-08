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
                "22815", 120, 4, "class_math_sp1", "exam_math_sp1");
        math_dept.addCourse(math_sp1);
        SpecializedCourse math_sp2 = new SpecializedCourse("Ardashir", "Basics of Math.",
                "22142", 70, 4, "class_math_sp2", "exam_math_sp2");
        math_dept.addCourse(math_sp2);
        GeneralCourse math_gn1 = new GeneralCourse("Chatrchi", "Islamic Thought(1)",
                "37445", 44, 2, "class_math_gn1", "exam_math_gn1");
        math_dept.addCourse(math_gn1);

        SpecializedCourse phys_sp1 = new SpecializedCourse
                ("Khosravi", "Cosmology", "24922", 35, 3, "class_phys_sp1", "exam_phys_sp1");
        phys_dept.addCourse(phys_sp1);
        SpecializedCourse phys_sp2 = new SpecializedCourse
                ("Abolhasani", "Relativity", "24144", 47, 3, "class_phys_sp2", "exam_phys_sp2");
        phys_dept.addCourse(phys_sp2);
        GeneralCourse phys_gn1 = new GeneralCourse
                ("Mir", "Islamic Thought(2)", "37446", 49, 2, "class_phys_gn1", "exam_phys_gn1");
        phys_dept.addCourse(phys_gn1);

        SpecializedCourse chem_sp1 = new SpecializedCourse
                ("Hazrati", "Organic Chem.", "23327", 50, 3, "class_chem_sp1", "exam_chem_sp1");
        chem_dept.addCourse(chem_sp1);
        SpecializedCourse chem_sp2 = new SpecializedCourse
                ("Setayesh", "Physical Chemistry", "23421", 40, 3, "class_chem_sp2", "exam_chem_sp2");
        chem_dept.addCourse(chem_sp2);
        GeneralCourse chem_gn1 = new GeneralCourse
                ("Jahazi", "Life Style", "37127", 42, 2, "class_chem_gn1", "exam_chem_gn1");
        chem_dept.addCourse(chem_gn1);

        SpecializedCourse comp_sp1 = new SpecializedCourse
                ("Hesabi", "Logic Circuits", "40212", 92, 3, "class_comp_sp1", "exam_comp_sp1");
        comp_dept.addCourse(comp_sp1);
        SpecializedCourse comp_sp2 = new SpecializedCourse
                ("Jalili", "Operating Systems", "40424", 50, 3, "class_comp_sp2", "exam_comp_sp2");
        comp_dept.addCourse(comp_sp2);
        GeneralCourse comp_gn1 = new GeneralCourse
                ("Gerami", "History of Imamate", "37622", 49, 2, "class_comp_gn1", "exam_comp_gn1");
        comp_dept.addCourse(comp_gn1);
    }
}
