import java.util.Scanner;
public class Condition2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the salary: ");
        double empSalary = scanner.nextDouble();
        double bonus;
        if (empSalary >= 5000) {
            bonus = 2000;
        } 
        else {
            bonus = 4000;
        }
        double newSalary = empSalary + bonus;
        System.out.println("New Salary: " + newSalary);
    }
}