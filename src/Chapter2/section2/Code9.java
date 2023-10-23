package Chapter2.section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code9 {
    // 입력으로 하나의 직교 다각형 (모든 변이 x축 또는 y축과 평행한 다각형)과 또하나의 점 p가 주어질 떄 그 점이 다각형의 내부에 있는지 외부에 있는지 판단하는 프로그램을 작성하라
    // ex) 시계방향으로 꼭지점의 좌표가 주어짐
    // 내/외부 검사시 p로 부터 무한히 뻗어지는 한 선을 만들어 다각형의 선과 만나는 지점의 갯수로 구분

    public static void main(String[] args) {

        try {
            Scanner inputFile = new Scanner(new File("H:\\코리아IT\\Spring_boot\\Java_data_structure_study\\src\\data.txt"));
            int n = inputFile.nextInt();
            System.out.println(n);
            OrthoPolygon thePolygon = new OrthoPolygon(n);
            for (int i = 0; i < n; i++) {
                thePolygon.addVertex(inputFile.nextInt(), inputFile.nextInt());
                System.out.println(inputFile.nextInt() + "," + inputFile.nextInt());
            }
            MyPoint2 thePoint = new MyPoint2(inputFile.nextInt(), inputFile.nextInt());
            inputFile.close();
            if(thePolygon.contains(thePoint)){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        } catch (FileNotFoundException e) {
            System.out.println("No data file exists.");
            System.exit(1);
        }
    }
}
