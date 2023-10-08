package Chapter1.Lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code18 {
    public static void main(String[] args) {
        // 파일안에 있는 데이터를 Scanner로 읽어와서 화면에 출력

        String[] name = new String[1000];
        String[] number = new String[1000];
        int n = 0;

        try {
            Scanner inFile = new Scanner(new File("H:\\코리아IT\\Spring_boot\\Java_data_structure_study\\src\\input.txt"));

            while (inFile.hasNext()) { // inFile 안에 다음 데이터가 있으면 반복
                name[n] = inFile.next();
                number[n] = inFile.next();
                n++;
            }

            inFile.close();
        } catch (FileNotFoundException e) { // 파일이 존재 하지 않을 시 실행
            System.out.println("No File");
            System.exit(0);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(name[i] + ": " + number[i]);
        }
    }
}
