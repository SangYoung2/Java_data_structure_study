package Chapter3.section4_2;

public class RtTriangle extends Shape{
    public int width;
    public int height;
    public int diagonal;

    public RtTriangle(int width, int height) {
        super("RtTriangle");
        this.width = width;
        this.height = height;
        diagonal = (int)Math.sqrt((Math.pow(width,2) + Math.pow(height,2)));
    }

    @Override
    public double computeArea() {
        return diagonal;
    }

    @Override
    public double computePerimeter() {
        return width + height + diagonal;
    }
}
