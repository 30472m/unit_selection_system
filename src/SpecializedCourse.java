public class SpecializedCourse extends Course {

    public SpecializedCourse(String fac_name, String crs_name, String crs_code,
                             int cap, int crdt, String cls_time, String ex_time) {

        super(fac_name, crs_name, crs_code, cap, crdt, cls_time, ex_time);
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%-5s", "SP");
    }

}
