public class RelaxationPackage extends VocationPackage {
    private String[] spa_services;

    public RelaxationPackage(String destination, double price, String[] spa_services) {
        super(destination, price);
        this.spa_services = spa_services;
    }

    @Override
    public void display_details() {
        System.out.println("Destination: " + destination);
        System.out.println("Price: $" + price);
        System.out.print("Spa Services: ");
        
        for (int i = 0; i < spa_services.length; i++) {
            System.out.print(spa_services[i] + " ");
        }
    }
}
