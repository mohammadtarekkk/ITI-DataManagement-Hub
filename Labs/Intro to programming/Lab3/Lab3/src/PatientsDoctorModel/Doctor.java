public class Doctor extends Person
{
    String Speciality;
    public Doctor(String name, int age, String Speciality)
    {
        this.name = name;
        this.age = age;
        this.Speciality = Speciality;
    }
    public void get_details()
    {
        System.out.println("Doctor Name: " + name + ", Age: " + age + ", Speciality: " + Speciality);
    }

}
