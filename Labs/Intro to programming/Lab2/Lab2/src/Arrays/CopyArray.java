public class CopyArray {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 88, 64, 23, 0, 74, 89, 123, 0};
        int[] copy = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            copy[i] = numbers[i];
        }   
        for (int num : copy) {
            System.out.print(num + " ");
        }
    }
}