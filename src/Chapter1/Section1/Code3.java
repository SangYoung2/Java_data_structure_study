package Chapter1.Section1;

import java.util.Scanner;

public class Code3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String str = "Hello";
        String inputStr = null; // null 부분을 생략하더라도 변수의 값은 null이 들어간다.

        System.out.println("Please type a string : ");
        inputStr = input.next(); // scanf(%s, ...) 와 같다. next는 한단어만 가져오고 문장 전체는 nextLine을 사용해야한다.

        if(str.equals(inputStr)) { // String변수는 "=="가 아닌 equals로 비교해야 된다.
            System.out.println("Strings match! :)");
        } else {
            System.out.println("Strings do not match! :(");
        }

        input.close();
    }
}
