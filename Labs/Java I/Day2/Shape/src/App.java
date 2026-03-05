public class App {
    public static void main(String[] args) throws Exception {
        Shape circle = new Circle(7.0f);
        Shape rectangle = new Rectangle(4.0f, 5.0f);
        Shape triangle = new Triangle(4.0f, 5.0f);
        Picture picture = new Picture();
        Float totalArea = picture.sumAreas(circle, rectangle, triangle);
        System.out.println("Total Area: " + totalArea);
    }
}