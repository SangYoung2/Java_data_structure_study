package Chapter2.section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code3 {
    //Code2에 bubbleSort(버블정렬)을 추가한 코드
    static Person1[] members = new Person1[100];
    static int n = 0;

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(new File("H:\\코리아IT\\Spring_boot\\Java_data_structure_study\\src\\input.txt"));

            while (input.hasNext()) {
                String nm = input.next();
                String num = input.next();

                members[n] = new Person1();
                members[n].name = nm;
                members[n].number = num;
                n++;
            }

            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("No data file");
        }

        bubbleSort();

        for (int i = 0; i < n; i++) {
            System.out.println(members[i].name + ": " + members[i].number);
        }

    }

    static void bubbleSort() {
        for (int i = n-1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(members[j].name.compareTo(members[j+1].name) > 0) {
                    // compareTo 로 String값을 서로 비교하여 양수, 0, 음수 int값으로 반환
                    // 글자의 경우 아스키 코드로 비교하여 정렬하기 때문에 알파벳 순서로 정렬을 해준다.
                    // 하나의 Person객체 안에 name과 number가 있기 때문에 객체만 바꿔주면 된다.
                    Person1 tmp = members[j];
                    members[j] = members[j+1];
                    members[j+1] = tmp;
                }
            }
        }
    }


}
