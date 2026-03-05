public class App {
    public static void main(String[] args) throws Exception {
        Calc calc = new Calc(10, "+", 5);
        int result = calc.calculate();
        System.out.println("Result: " + result);
    }
}
