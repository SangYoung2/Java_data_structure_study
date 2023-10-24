package Chapter2.section3;

import java.util.Scanner;

public class Code1 {
    // section2의 code7안에 있는 코드들에서 main함수를 제외하고 static을 지워보기

    Polynomial3[] polys = new Polynomial3[100];
    int n = 0;
    
    public void processCommand(){
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

    public static void main(String[] args) {
        Code1 app = new Code1();
        app.processCommand();
    }

    public int find(char name) {
        for (int i = 0; i < n; i++) {
            if (polys[i].name == name) {
                return i;
            }
        }
        return -1;
    }
}
