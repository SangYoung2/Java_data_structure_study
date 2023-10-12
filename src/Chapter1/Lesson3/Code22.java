package Chapter1.Lesson3;

import java.io.*;
import java.util.Scanner;

public class Code22 {
    // Code21의 문제점들을 보완 - 알파벳 순으로 정렬, 대(소)문자 구분없이 통일, 특수문자(기호) 제외, 숫자 제외


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
        }
    }

    static void makeIndex(String fileName) {

        try {
            Scanner inFile = new Scanner(new File(fileName));

            while (inFile.hasNext()) {
                String str = inFile.next();

                String trimmed = trimming(str); // 단어의 앞,뒤에 특수문자 또는 숫자를 제거
                if(trimmed != null) { //null 값이 아닌 단어만 추가한다
                    String t = trimmed.toLowerCase(); // 소문자로 변환하여 저장
                    addWord(t);
                }
            }

            inFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No File!");
        }

    }

    static String trimming(String str) { // 단어의 앞,뒤의 특수 문자를 제거
        int i = 0, j = str.length()-1;

        while (i < str.length() && !Character.isLetter(str.charAt(i))){ // i번째 문자가 영어가 아니라면 i값을 증가시킨다.
            // Character.isLetter 는 알파벳인지 확인하는 기능
            i++;
        }
        while (j >= 0 && !Character.isLetter(str.charAt(j))) { // 뒤에서 부터 검사하며 특수문자나
            j--;
        }

        if(i >= j) { // 알파벳이 없는 경우에는 오류가 발생 하기에 그럴 경우에는 null값을 반환
            return null;
        }
        return str.substring(i, j+1); // substring은 [ ) 구조이기 때문에 i부터 j-1까지 잘라서 출력하기 때문에 j까지 하려면 j+1으로 해야한다.
        
    }

    static void addWord(String str) {
        int index = findWord(str); // 찾지 못하면 -1로 반환
        if (index != -1) { // 단어가 이미 존재
            count[index]++; // 해당하는 index의 count갯수를 증가
        } else { // 단어가 존재 하지 않음
            int i = n-1;
            while (i >= 0 && words[i].compareToIgnoreCase(str) > 0) { // 배열의 맨 뒤에서 부터 비교하여 정렬하면서 추가
                words[i+1] = words[i];
                count[i+1] = count[i];
                i--;
            }
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
