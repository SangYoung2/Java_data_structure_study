package Chapter2.Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code2 {
    static Person1[] members = new Person1[100];
    static int n = 0;

    public static void main(String[] args) {

        try {
            Scanner inputFile = new Scanner(new File("H:\\코리아IT\\Spring_boot\\Java_data_structure_study\\src\\input.txt"));

            while (inputFile.hasNext()) { // inputFile 안에 있는 데이터를 가져와서 members 배열 안에 저장한다.
                String nm = inputFile.next();
                String num = inputFile.next();

                members[n] = new Person1();
                members[n].name = nm;
                members[n].number = num;
                n++;
            }

            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file");
        }

        for (int i = 0; i < n; i++) { // members안에 있는 데이터를 출력
            System.out.println(members[i].name + ": " + members[i].number);
        }

    }
}
