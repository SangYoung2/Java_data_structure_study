package Chapter1.Section2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code19 {

    static String[] name = new String[1000];
    static String[] number = new String[1000];
    static int n = 0;

    public static void main(String[] args) {
        // 파일안에 있는 데이터를 Scanner로 읽어와서 화면에 출력

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

        bubbleSort();

        for (int i = 0; i < n; i++) {
            System.out.println(name[i] + ": " + number[i]);
        }
    }

    static void bubbleSort() {
        for (int i = n-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(name[j].compareTo(name[j+1]) > 0) {
                    // compareTo 로 String값을 서로 비교하여 양수, 0, 음수 int값으로 반환
                    // 글자의 경우 아스키 코드로 비교하여 정렬하기 때문에 알파벳 순서로 정렬을 해준다.
                    String tmp = name[j];
                    name[j] = name[j+1];
                    name[j+1] = tmp;

                    tmp = number[j];
                    number[j] = number[j+1];
                    number[j+1] = tmp;
                }
            }
        }
    }
}
