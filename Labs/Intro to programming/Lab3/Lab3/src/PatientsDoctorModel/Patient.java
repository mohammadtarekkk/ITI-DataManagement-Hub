public class Patient extends Person
{
    String medical_history;
    public Patient(String name, int age, String medical_history)
    {
        this.name = name;
        this.age = age;
        this.medical_history = medical_history;
    }
    public void get_details()
    {
        System.out.println("Patient Name: " + name + ", Age: " + age + ", Medical History: " + medical_history);
    }
}
