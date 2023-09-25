package Lesson1;

import java.util.Scanner;

public class Code1 {
    static int num;

    public static void main(String[] args) { // main method

        int anotherNum = 5;

        num = 2;

        System.out.println(num + anotherNum);
        System.out.println("Num : " + num);
        System.out.println("AnotherNum : " + anotherNum);
        // left associativity ("+"가 여러번 사용되면 맨 왼쪽의 "+"가 먼저 실행된다)
        System.out.println("Sum : " + num + anotherNum); // 결과 : "Sum : 25"
        System.out.println("Sum : " + (num + anotherNum)); // 결과 : "Sum : 7"

    }
}
