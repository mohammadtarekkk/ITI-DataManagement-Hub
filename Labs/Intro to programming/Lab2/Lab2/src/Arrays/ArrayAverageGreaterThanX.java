public class ArrayAverageGreaterThanX {
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5, 88, 64, 23, 0, 74, 89, 123, 0};
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > average) {
                System.out.println("Element greater than average: " + numbers[i]);
            }
        }
    }
}