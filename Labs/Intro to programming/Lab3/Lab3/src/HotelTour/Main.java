
public class Main {
    public static void main(String[] args) {
        HotelPackage hotelPackage = new HotelPackage(10, 100);
        hotelPackage.calculate_total_cost();
        hotelPackage.display_package_cost();

        TourPackage tourPackage = new TourPackage(5, 150);
        tourPackage.calculate_total_cost();
        tourPackage.display_package_cost();
    }
}
