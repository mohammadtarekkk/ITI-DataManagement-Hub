public class Main {
    public static void main(String[] args) {
        Patient patient1 = new Patient("Omar", 30, "Hypertension");
        Doctor doctor1 = new Doctor("Dr. Hesham", 45, "Cardiology");

        patient1.get_details();
        doctor1.get_details();
    }
}
