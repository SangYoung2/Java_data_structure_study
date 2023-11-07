package Chapter3.section4_2;

public abstract class Shape implements MyComparable {
    public  String shapeName;

    public Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    public abstract double computeArea();
    public abstract double computePerimeter();

    @Override
    public int compareTo(Object obj) {
        double myArea = computeArea();
        double yourArea = ((Shape)obj).computeArea();
        if(myArea < yourArea) {
            return -1;
        }else if (myArea == yourArea) {
            return 0;
        } else {
            return -1;
        }
    }
}
