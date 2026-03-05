public class SumOfTwoArraysSameIndex {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {10, 20, 30, 40, 50};
        int[] sumArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            sumArray[i] = array1[i] + array2[i];
        }
        System.out.println("Sum of elements at the same index:");
        for (int sum : sumArray) {
            System.out.print(sum + " ");
        }
    }
}