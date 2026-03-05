public class M03 {
    public static void main(String[] args) {
        int radius = 7;
        System.out.println("Area of circle with radius " + radius + " is: " + calculateAreaOfCircle(radius));
    }
    // Method to Calculate Area of Circle
    public static double calculateAreaOfCircle(int radius) {
        return Math.PI * radius * radius;
    }}