public class TourPackage extends TravelPackage {
    private int days;
    private int cost_per_day;

    public TourPackage(int days, int cost_per_day) {
        this.days = days;
        this.cost_per_day = cost_per_day;
    }

    @Override
    public void calculate_total_cost() {
        double baseCost = days * cost_per_day;
        totalCost = baseCost - (baseCost * 0.10);
    }
    @Override
    public void display_package_cost() {
        System.out.println("Total Cost for Tour Package: " + totalCost);
    }
}
