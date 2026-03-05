public class ComplexNum {
    private int real;
    private int imag;

    public ComplexNum(int real, int imag) {
        this.real = real;
        this.imag = imag;
    }

    public int getReal() {
        return real;
    }

    public int getImag() {
        return imag;
    }
    public static void subtractNum(ComplexNum num1, ComplexNum num2) {
        int realPart = num1.getReal() - num2.getReal();
        int imagPart = num1.getImag() - num2.getImag();
        System.out.println("Subtraction: " + realPart + "+" + imagPart + "i");
    }

    public static void addNum(ComplexNum num1, ComplexNum num2) {
        int realPart = num1.getReal() + num2.getReal();
        int imagPart = num1.getImag() + num2.getImag();
        System.out.println("Addition: " + realPart + "+" + imagPart + "i");
    }
}