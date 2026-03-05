public abstract class VocationPackage {
    String destination;
    double price;
    public VocationPackage(String destination, double price) {
        this.destination = destination;
        this.price = price;
    }
    public String getDestination() {
        return destination;
    }
    public double getPrice() {
        return price;
    }
    public abstract void display_details();
}
