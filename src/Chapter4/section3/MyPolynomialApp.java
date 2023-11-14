package Chapter4.section3;

import Chapter4.section2.Polynomial;

import java.util.Scanner;

public class MyPolynomialApp {

    private Chapter4.section2.Polynomial[] polys = new Chapter4.section2.Polynomial[100];
    int n = 0;
    Scanner input = new Scanner(System.in);
    public MyPolynomialApp() {

    }

    public void processCommand() {
        while (true) {
            System.out.print("$ ");
            String command = input.next();
            if(command.equals("create")) {
                handleCreate();
            }
            else if(command.equals("add")) {
                handleAdd();
            }
            else if(command.equals("calc")) {
                handleCalc();
            }
            else if(command.equals("print")) {
                handlePrint();
            }
            else if(command.equals("exit")) {
                break;
            }
        }
        input.close();
    }

    private void handlePrint() {
        char name = input.next().charAt(0); // next로 받으면 단어로 받기 때문에 0번째 문자를 name에 저장
        int index = find(name);
        if(index < 0) {
            System.out.println("No such polynomial");
            return;
        }
        System.out.println(polys[index].toString());
    }

    private void handleCalc() {
        char name = input.next().charAt(0); // next로 받으면 단어로 받기 때문에 0번째 문자를 name에 저장
        int x = input.nextInt();
        int index = find(name);
        if(index < 0) {
            System.out.println("No such polynomial");
            return;
        }
        polys[index].calc(x);
    }

    private void handleAdd() {
        char name = input.next().charAt(0); // next로 받으면 단어로 받기 때문에 0번째 문자를 name에 저장
        int coef = input.nextInt();
        int expo = input.nextInt();
        int index = find(name);
        if(index < 0) {
            System.out.println("No such polynomial");
            return;
        }
        polys[index].addTerm(coef, expo);
    }

    private int find(char name){
        for (int i = 0; i < n; i++) {
            if(polys[i].name == name){
                return i;
            }
        }
        return -1;
    }

    private void handleCreate() {
        char name = input.next().charAt(0); // next로 받으면 단어로 받기 때문에 0번째 문자를 name에 저장
        Chapter4.section2.Polynomial p = new Polynomial(name);
        polys[n++] = p; // polys에 저장 후 n을 +1시킨다.
    }

    public static void main(String[] args) {
        MyPolynomialApp app = new MyPolynomialApp();
        app.processCommand();
    }


}
