public class FindSecondLargest {
    public static void main(String[] args){
        int[] numbers = {1, 2, 3, 4, 5, 88, 64, 23, 0, 74, 89, 123, 0};
        int largest = numbers[0];
        int secondLargest = numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > largest) {
                secondLargest = largest;
                largest = numbers[i];
            } 
        }
        System.out.println("Second largest element: " + secondLargest);
    }
}