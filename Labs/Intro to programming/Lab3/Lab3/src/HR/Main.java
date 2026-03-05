public class Main {
    public static void main(String[] args) {
        TechnicalDepartment tech = new TechnicalDepartment();
        tech.add_employee("Alice");
        tech.add_employee("Bob");
        HRDepartment hr = new HRDepartment();
        hr.add_employee("Charlie");
        tech.display_department();
        hr.display_department();        
    }
}
