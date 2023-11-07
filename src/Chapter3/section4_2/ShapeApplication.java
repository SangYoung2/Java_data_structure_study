package Chapter3.section4_2;

import Chapter3.section4.Event;

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
                handleSort();
            }
            else if(command.equals("exit")){
                break;
            }
        }
        input.close();
    }

    private void handleSort() {
    }

    private void handleShow(boolean detailed) {
        for (int i = 0; i < n; i++) {
            System.out.println((i+1) + ": " + shapes[i].toString());
            if(detailed) {
                System.out.println("    The area is " + shapes[i].computerArea());
                System.out.println("    The perimeter is " + shapes[i].computerPerimeter());
            }
        }
    }

    private void handleAdd() {
        System.out.println("$ ");
        String type = input.next();
        switch (type) {
            case "R" :
                System.out.print("$ width: ");
                int w = input.nextInt();
                System.out.print("$ height: ");
                int h = input.nextInt();
                Rectangle r = new Rectangle(w, h);
                addShape(r);
                break;
            case "C" :
                System.out.print("$ radius: ");
                addShape(new Circle(input.nextInt()));
                break;
            case "T" :
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
