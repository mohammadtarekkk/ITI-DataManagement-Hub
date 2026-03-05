public class HotelPackage extends TravelPackage {
    private int nights;
    private int cost_per_night;

    public HotelPackage(int nights, int cost_per_night) {
        this.nights = nights;
        this.cost_per_night = cost_per_night;
    }   

    @Override
    public void calculate_total_cost() {
        totalCost = nights * cost_per_night;
    }
    @Override
    public void display_package_cost() {
        System.out.println("Total Cost for Hotel Package: " + totalCost);
    }

}
