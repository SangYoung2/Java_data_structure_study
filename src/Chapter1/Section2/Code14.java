package Chapter1.Section2;

import java.util.Scanner;

public class Code14 {
    public static void main(String[] args) {
        // 입력으로 두 정수 a, b를 받아 a의 b승을 계산한다.
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        int result = power(a, b); // 메서드 power를 호출하여 a,b값을 전달하여 리턴 된 값을 result에 저장

        System.out.println(result);

        input.close();

    }

    static int power(int a, int b) { // 전달받은 a, b 값을 사용하여 a의 b승의 값을 계산하여 리턴한다.
        int prod = 1;
        for (int i = 0; i < b; i++) {
            prod *= a;
        }

        return prod;
    }

}
