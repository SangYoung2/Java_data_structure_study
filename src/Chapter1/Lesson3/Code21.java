package Chapter1.Lesson3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code21 {

    static String[] words = new String[100000];
    static int[] count = new int[100000];

    static int n = 0;

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        while (true) {

            System.out.print("$ ");
            String command = kb.next();
            if (command.equals("read")) {
                String fileName = kb.next();
                makeIndex(fileName);
            } else if (command.equals("find")) {

            } else if (command.equals("saves")) {

            } else if (command.equals("exit")) {
                break;
            }
        }

        kb.close();
    }

    static void makeIndex(String fileName) {

        try {
            Scanner inFile = new Scanner(new File(fileName));

            while (inFile.hasNext()) {
                String str = inFile.next();

                addWord(str);


            }

            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No File!");
        }

    }

    static void addWord(String str) {
        int index = findWord(str); // 찾지 못하면 -1로 반환
        if (index != -1) { //찾음
            count[index]++;
        } else { //못 찾음

        }
    }

    static int findWord(String str) {
        for (int i = 0; i < n; i++) {
            if (words[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

}
