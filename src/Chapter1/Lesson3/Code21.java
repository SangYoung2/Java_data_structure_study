package Chapter1.Lesson3;

import java.io.*;
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
            }
            else if (command.equals("find")) {
                String str = kb.next();
                int index = findWord(str);
                if(index != -1){
                    System.out.println("The word " + words[index] + " appears " + count[index] + " times.");
                }
                else {
                    System.out.println("The word " + str + " does not appears. ");
                }
            }
            else if (command.equals("saveas")) {
                String fileName = kb.next();
                saveAs(fileName);

            }
            else if (command.equals("exit")) {
                break;
            }
        }

        kb.close();
    }

    static void saveAs(String fileName) {
        try {
            PrintWriter outFile = new PrintWriter(new FileWriter(fileName));

            for (int i = 0; i < n; i++) {
                // 모니터에 출력을 하고 싶을 경우 System.out.print를 입력
                // 파일에 출력을 하고 싶을 경우 파일명.print를 입력
                outFile.println("The word " + words[i] + " appears " + count[i] + " times.");
            }

            outFile.close();
        } catch (IOException e) {
            System.out.println("Save failed");
            return;
        }
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
            count[index]++; // 해당하는 index의 count갯수를 증가
        } else { //못 찾음
            words[n] = str; // 새로운 단어 추가
            count[n] = 1; // 새로운 단어의 카운터 증가
            n++; // 총 갯수 증가
        }
    }

    static int findWord(String str) {
        for (int i = 0; i < n; i++) {
            if (words[i].equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

}
