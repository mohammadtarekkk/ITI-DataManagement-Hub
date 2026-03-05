public class Triangle extends Shape {
    public Triangle(Float base, Float height) {
        this.dimension = base;
        Float h = height;
        this.Area = 0.5f * dimension * h;
    }

    @Override
    public Float calculateArea() {
        return this.Area;
    }
}