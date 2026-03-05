// Step 1: We must import the Scanner class to use it.
import java.util.Scanner;

public class Condition1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter an integer to check: ");
        int num= scanner.nextInt();
        System.out.println("Checking the number: " + num);
        if (num % 6 == 0) {
            System.out.println("divisible");
        } else {
            System.out.println("not divisible");
        }
    }
}