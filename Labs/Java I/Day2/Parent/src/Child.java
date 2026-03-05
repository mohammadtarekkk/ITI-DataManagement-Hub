public class Child extends Parent {
    private int num3;
    public Child(int num1, int num2, int num3) {
        super(num1, num2);
        this.num3 = num3;
    }
    public int sum() {
        // can be super.num1 + super.num2 + num3;
        return super.sum() + num3;
    }
}