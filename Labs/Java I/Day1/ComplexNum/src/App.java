public class App {
    public static void main(String[] args) throws Exception {
        ComplexNum num1 = new ComplexNum(3, 4);
        ComplexNum num2 = new ComplexNum(1, 2);

        ComplexNum.addNum(num1, num2);
        ComplexNum.subtractNum(num1, num2);
    }
}