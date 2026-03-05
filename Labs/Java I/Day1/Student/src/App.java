public class App {
    public static void main(String[] args) throws Exception {
        Student student1 = new Student("Mohammad", 23, "Data Management");
        Student student2 = new Student("Salah", 22, "Ddata Science");

        student1.printInfo();
        student2.printInfo();
    }
}