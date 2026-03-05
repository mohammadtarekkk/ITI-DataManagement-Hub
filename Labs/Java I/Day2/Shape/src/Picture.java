public class Picture {
    public Float sumAreas(Shape shape1, Shape shape2, Shape shape3) {
        Float totalArea = 0.0f;
        totalArea += shape1.calculateArea();
        totalArea += shape2.calculateArea();
        totalArea += shape3.calculateArea();
        return totalArea;
    }
}