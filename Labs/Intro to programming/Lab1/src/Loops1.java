import java.util.Scanner;

public class Loops1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int positive = 0;
        int negative = 0;
        int zero = 0;
        double positiveSum = 0;
        double negativeSum = 0;
        System.out.println("Please enter 5 numbers: ");
        for (int i = 0; i < 5; i++) {
            double num = scanner.nextDouble();
            if (num > 0) {
                positive++;
                positiveSum += num;
            } else if (num < 0) {
                negative++;
                negativeSum += num;
            } else {
                zero++;
            }
        }
        System.out.println("Sum of positive numbers: " + positiveSum + " Count of positive numbers: " + positive);
        System.out.println("Sum of negative numbers: " + negativeSum + " Count of negative numbers: " + negative);
        System.out.println("Count of zeros: " + zero);
    }
}
