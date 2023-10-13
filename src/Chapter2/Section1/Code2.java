package Chapter2.Section1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code2 {
    static Person1[] members = new Person1[100];
    static int n = 0;

    public static void main(String[] args) {

        try {
            Scanner input = new Scanner(new File("input.txt"));

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

        for (int i = 0; i < n; i++) {
            System.out.println(members[i].name + ": " + members[i].number);
        }

    }
}
