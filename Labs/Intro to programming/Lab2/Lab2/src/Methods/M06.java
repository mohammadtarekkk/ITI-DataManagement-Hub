public class M06 {
    public static void main(String[] args) {
        System.out.println("Prime numbers from 1 to 100 are:");
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    // 6.	Method to Find all prime numbers from 1 to 100
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}