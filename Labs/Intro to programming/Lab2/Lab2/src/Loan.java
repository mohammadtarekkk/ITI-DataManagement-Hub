public class Loan {
    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;

    public Loan() {
        this.annualInterestRate = 2.5;
        this.numberOfYears = 1;
        this.loanAmount = 1000;
    }
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
    }
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }
    public int getNumberOfYears() {
        return numberOfYears;
    }
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }
    public double getLoanAmount() {
        return loanAmount;
    }
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 12;
        double monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfYears * 12));
        return monthlyPayment;

    }
    public double calculateTotalPayment() {
        return calculateMonthlyPayment() * numberOfYears * 12;
    }
    public static void main(String[] args) {
        Loan loan1 = new Loan();
        System.out.printf("Monthly Payment for loan1: %.2f%n", loan1.calculateMonthlyPayment());
        System.out.printf("Total Payment for loan1: %.2f%n", loan1.calculateTotalPayment());

        Loan loan2 = new Loan(5, 15, 20000);
        System.out.printf("Monthly Payment for loan2: %.2f%n", loan2.calculateMonthlyPayment());
        System.out.printf("Total Payment for loan2: %.2f%n", loan2.calculateTotalPayment());
    }
}
