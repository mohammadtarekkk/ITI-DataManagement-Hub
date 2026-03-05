public class Rectangle extends Shape {
    public Rectangle(Float length, Float width) {
        this.dimension = length;
        Float w = width;
        this.Area = dimension * w;
    }

    @Override
    public Float calculateArea() {
        return this.Area;
    }
}