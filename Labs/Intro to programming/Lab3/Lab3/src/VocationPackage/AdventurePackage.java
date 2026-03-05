public class AdventurePackage extends VocationPackage {
    private String[] sea_activities;
    public AdventurePackage(String destination, double price, String[] sea_activities) {
        super(destination, price);
        this.sea_activities = sea_activities;
    }

    @Override
    public void display_details() {
        System.out.println("Destination: " + destination);
        System.out.println("Price: $" + price);
        System.out.print("Activities: ");
        
        for (int i = 0; i < sea_activities.length; i++) {
            System.out.print(sea_activities[i] + " ");
        }       }
    }
