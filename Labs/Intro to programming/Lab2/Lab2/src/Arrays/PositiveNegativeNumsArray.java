public class PositiveNegativeNumsArray {
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5, 88, 64, 23, 0, 74, 89, 123, 0};
        int countEven = 0;
        int countOdd = 0;
        int countZero = 0;
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                countZero++;
            } else if (numbers[i] % 2 == 0) {
                countEven++;
                sumEven += numbers[i];
            } else {
                countOdd++;
                sumOdd += numbers[i];
            }
        }
        System.out.println("Count of even numbers: " + countEven);
        System.out.println("Sum of even numbers: " + sumEven);
        System.out.println("Count of odd numbers: " + countOdd);
        System.out.println("Sum of odd numbers: " + sumOdd);
        System.out.println("Count of zero numbers: " + countZero);
    }
}