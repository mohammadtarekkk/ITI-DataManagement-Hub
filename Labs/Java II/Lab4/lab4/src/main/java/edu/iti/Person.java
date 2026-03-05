package edu.iti;

public class Person {
    private int id;
    private String firstName, middleName, lastName, email, phone;

    public Person() {}
    
    public Person(int id, String fName, String mName, String lName, String email, String phone) {
        this.id = id;
        this.firstName = fName;
        this.middleName = mName;
        this.lastName = lName;
        this.email = email;
        this.phone = phone;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}