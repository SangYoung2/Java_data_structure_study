package Chapter2.section2;

import Chapter2.section1.MyPoint1;
import Chapter2.section1.MyRectangle1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code8 {

    static MyRectangle2[] rects = new MyRectangle2[10000];
    static int n = 0;

    public static void main(String[] args) {
        try {
            Scanner inFile = new Scanner(new File("H:\\코리아IT\\Spring_boot\\Java_data_structure_study\\src\\pointdata.txt"));
            while (inFile.hasNext()) {

                rects[n] = new MyRectangle2(inFile.nextInt(), inFile.nextInt(), inFile.nextInt(), inFile.nextInt());

                n++;

            }

            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("no data File");
            System.exit(1);
        }

        bubbleSort();

        for (int i = 0; i < n; i++) {
            System.out.println(rects[i].toString());
        }
    }

    static void bubbleSort(){
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if( rects[j].calcArea() > rects[j+1].calcArea() ) {
                    MyRectangle2 tmp = rects[j];
                    rects[j] = rects[j+1];
                    rects[j+1] = tmp;
                }
            }
        }
    }


}
