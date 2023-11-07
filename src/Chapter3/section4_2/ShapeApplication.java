package Chapter3.section4_2;

import java.util.Arrays;
import java.util.Scanner;

public class ShapeApplication {
    private int capacity = 10;
    private Shape[] shapes = new Shape[capacity];
    private int n = 0;
    private Scanner input = new Scanner(System.in);

    public void processCommand(){
        while (true){
            System.out.print("$ ");
            String command = input.next();
            if(command.equals("add")) {
                handleAdd();
            }
            else if (command.equals("show") || command.equals("showdetail")) {
                handleShow(command.equals("showdetail"));
            }
            else if(command.equals("sort")) {
//                handleSort(shapes, n);
                Arrays.sort(shapes,0, n); //shapes 배열의 0번 부터 n번째 까지 정렬 하는 자바자체에 가지고 있는 정렬 (단, 정리할 배열은 Comparable을 implements하고있어야한다.)
            }
            else if(command.equals("exit")){
                break;
            }
        }
        input.close();
    }

//    private void handleSort() {
//        for (int i = n-1; i > 0; i--) {
//            for (int j = 0; j < i; j++) {
//                if(shapes[j].computeArea() > shapes[j+1].computeArea()) {
//                    Shape tmp = shapes[j];
//                    shapes[j] = shapes[j+1];
//                    shapes[j+1] = tmp;
//                }
//            }
//        }
//    }

    private void handleSort(MyComparable[] data, int size ) {
        for (int i = size-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(data[j].compareTo(data[j+1]) > 0) {
                    MyComparable tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }
    }

    private void handleShow(boolean detailed) {
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + ": " + shapes[i].toString());
            if(detailed) {
                System.out.println("    The area is " + shapes[i].computeArea());
                System.out.println("    The perimeter is " + shapes[i].computePerimeter());
            }
        }
    }

    private void handleAdd() {
        System.out.print("$ Please enter Shape: ");
        String type = input.next();
        switch (type) {
            case "R" :
                System.out.print("$ width: ");
                int rw = input.nextInt();
                System.out.print("$ height: ");
                int rh = input.nextInt();
                Rectangle r = new Rectangle(rw, rh);
                addShape(r);
                break;
            case "C" :
                System.out.print("$ radius: ");
                addShape(new Circle(input.nextInt()));
                break;
            case "T" :
                System.out.print("$ width: ");
                int tw = input.nextInt();
                System.out.print("$ height: ");
                int th = input.nextInt();
                RtTriangle t = new RtTriangle(tw, th);
                addShape(t);
                break;
        }
    }

    private void addShape(Shape shape) {
        if(n >= capacity){
            reallocate();
        }
        shapes[n++] = shape;
    }

    private void reallocate(){
        Shape[] tmpArray = new Shape[capacity * 2];
        System.arraycopy(shapes, 0, tmpArray, 0, shapes.length); // shapes 배열을 tmpArray 배열로 복사하는 기능
        shapes = tmpArray;
        capacity *= 2;
    }

    public static void main(String[] args) {
        ShapeApplication application = new ShapeApplication();
        application.processCommand();
    }
}
