package Chapter3.section4_2;

public abstract class Shape {
    public  String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public abstract double computerArea();
    public abstract double computerPerimeter();
}
