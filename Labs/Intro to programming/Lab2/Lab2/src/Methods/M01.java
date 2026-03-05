public class M01 {
    public static void main(String[] args) {
        int[] numbers = {1, -2, 3, 4, -5, 6, -7, 8, 9, -10};
        System.out.println("Sum of positive numbers: " + sumOfPositiveNumbers(numbers));
        System.out.println("Sum of negative numbers: " + sumOfNegativeNumbers(numbers));
    }
    // Method to find sum of positive numbers in array
    public static int sumOfPositiveNumbers(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num > 0) {
                sum += num;
            }
        }
        return sum;
    }

    // Method to find sum of negative numbers in array
    public static int sumOfNegativeNumbers(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num < 0) {
                sum += num;
            }
        }
        return sum;
    }}