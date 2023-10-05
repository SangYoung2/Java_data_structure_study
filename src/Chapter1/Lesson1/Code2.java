package Chapter1.Lesson1;

import java.util.Scanner;

public class Code2 {
    public static void main(String[] args) {
        int number = 123;

        Scanner input = new Scanner(System.in); // 스캐너를 만든다. (변수명은 개발자 마음대로)

        System.out.print("Please enter an integer : ");

        int inputNum = input.nextInt(); // 사용자가 입력한 값을 inputNum에 저장한다. ( sacnf(%d, &input) )

        if(inputNum == number) { // 입력한 값이 number와 같으면 실행
            System.out.println("Number match! :)");
        } else { // 입력한 값이 number와 다르면 실행
            System.out.println("Number do not match! :(");
        }

        input.close(); // 스캐너 사용이 완료되면 스캐너를 끈다.
    }
}
