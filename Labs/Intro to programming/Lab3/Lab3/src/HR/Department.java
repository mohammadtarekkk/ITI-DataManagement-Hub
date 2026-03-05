public class Department {
    String dept_name;
    private String[] employees = new String[100000]; 
    private int count = 0;
    public Department(String name){
        this.dept_name = name;
    }


    public void add_employee(String emp_name){
        if (count < employees.length) {
            employees[count] = emp_name;
            count++;
        }
    }
    public void display_department(){
        System.out.println("Department: " + dept_name);
        System.out.println("Employees:");
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }
}
