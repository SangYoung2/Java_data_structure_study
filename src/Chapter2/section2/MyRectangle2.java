package Chapter2.section2;

import Chapter2.section1.MyPoint1;
import Chapter2.section1.MyRectangle1;

public class MyRectangle2 {
    public MyPoint2 lu; // left upper (시작 꼭지점)
    public int width; // 너비
    public int height; // 높이

    public MyRectangle2() {
    }

    public MyRectangle2(MyPoint2 lu, int width, int height) {
        this.lu = lu;
        this.width = width;
        this.height = height;
    }

    public MyRectangle2(int x, int y, int width, int height) {
        this.lu = new MyPoint2(x, y) ;
        this.width = width;
        this.height = height;
    }

    public int calcArea() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        return lu.x + " " + lu.y + " " + width + " " + height;
    }
}
