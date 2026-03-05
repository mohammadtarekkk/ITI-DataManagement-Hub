public class Calc {
    private int num1;
    private int num2;
    private String operation;

    public Calc(int num1, String operation, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
    }
    
    public int calculate() {
        switch (operation) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;      
    }
        return 0;
}
}