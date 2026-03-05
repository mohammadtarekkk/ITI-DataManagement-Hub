public class ArrayGreaterThanX {
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5, 88, 64, 23, 0, 74, 89, 123, 0};
        int x = 50;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > x) {
                System.out.println(numbers[i]);
            }
        }
    }
}