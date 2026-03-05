public class Circle extends Shape {
    public Circle(Float radius) {
        this.dimension = radius;
        this.Area = 3.14f * dimension * dimension;
    }

    @Override
    public Float calculateArea() {
        return this.Area;
    }
}