package Chapter3.section4_2;

public class RtTriangle extends Shape{
    public int width;
    public int height;

    public RtTriangle(int width, int height) {
        super("RtTriangle");
        this.width = width;
        this.height = height;
    }

    @Override
    public double computerArea() {
        return 0;
    }

    @Override
    public double computerPerimeter() {
        return 0;
    }
}
