public class Problem6 {
    public static void main(String[] args) {
        double loanAmount = 100000;
        double monthlyRate = 0.01;
        int noYears = 7;
        double powerTerm = Math.pow(1 + monthlyRate, noYears * 12);
        double lower = 1 - (1 / powerTerm);
        double monthlyPayment = (loanAmount * monthlyRate) / lower;
        double totalPayment = monthlyPayment * noYears * 12;
        System.out.println("Monthly payment = " + monthlyPayment);
        System.out.println("Total payment = " + totalPayment);
    }
}