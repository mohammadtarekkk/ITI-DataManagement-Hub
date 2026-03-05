public class Main {
    public static void main(String[] args) {
        String[] firstActivities = {"Hiking", "Rafting"};
        AdventurePackage firstTrip = new AdventurePackage("Turkey", 2500, firstActivities);

        String[] secondActivities = {"Massage", "Yoga"};
        RelaxationPackage secondTrip = new RelaxationPackage("Hurghada", 3000, secondActivities);
        firstTrip.display_details();
        System.out.println("------------------------");
        secondTrip.display_details();
    }
}
