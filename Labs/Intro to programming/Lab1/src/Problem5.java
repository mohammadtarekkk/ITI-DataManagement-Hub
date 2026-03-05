public class Problem5 {
   public static void main(String[] args) {
        double a = 1.0;
        double b = 5.0;
        double c = 2.0;
        double equation = (b * b) - (4 * a * c);
        double root1 = (-b + Math.sqrt(equation)) / (2 * a);
        double root2 = (-b - Math.sqrt(equation)) / (2 * a);
        System.out.println(root1);
        System.out.println(root2);
    }
}