public class ReplaceNegativesWithZero {
    public static void main(String[] args){
        int[] numbers = {1, -2, 3, -4, 5, 88, -64, 23, 0, 74, 89, 123, 0};
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                numbers[i] = 0;
            }
        }
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}