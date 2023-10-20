package Chapter2.section2;

import java.util.Scanner;

public class Code7 {
    // 다항함수 - 다항함수는 항들의 함이며, 항은 계수와 지수에 의해서 정의된다. 계수는 0이 아닌 정수이고 지수는 움사가 아닌 정수라고 가정한다. ex) f{ }

    static Polynomial3[] polys = new Polynomial3[100];
    static int n = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = input.next();

            if(command.equals("create")) {
                char name = input.next().charAt(0); // Scanner에는 Char를 입력받는 명령어가 없기에 문자열로 받아서 첫번째 글자만 가져온다.
                polys[n] = new Polynomial3(name);
                n++;
            }
            else if (command.equals("add")) {
                char name = input.next().charAt(0);
                int index = find(name);
                if(index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int c = input.nextInt(); // 계수
                    int e = input.nextInt(); // 차수
                    polys[index].addTerm(c, e);
                }
            }
            else if (command.equals("calc")) {
                char name = input.next().charAt(0);
                int index = find(name);
                if(index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    int x = input.nextInt();
                    int result = polys[index].calcPolynomial(x);
                    System.out.println(result);
                }
            }
            else if (command.equals("print")) {
                char name = input.next().charAt(0);
                int index = find(name);
                if(index == -1) {
                    System.out.println("No such polynomial exists.");
                }
                else {
                    polys[index].printPolynomial();
                }
            }
            else if (command.equals("exit")) {
                break;
            }
        }
        input.close();
    }

    public static int find(char name) {
        for (int i = 0; i < n; i++) {
            if (polys[i].name == name) {
                return i;
            }
        }
        return -1;
    }
}
