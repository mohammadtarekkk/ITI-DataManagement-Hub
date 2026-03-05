public class M05 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 2, 1};
        if (isPalindromeArray(numbers)) {
            System.out.println("The array is a palindrome.");
        } else {
            System.out.println("The array is not a palindrome.");
        }
    }

    // 5.	Method to Check Palindrome Array
    public static boolean isPalindromeArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}