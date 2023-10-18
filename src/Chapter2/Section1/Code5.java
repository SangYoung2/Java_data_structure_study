package Chapter2.Section1;

import java.util.Scanner;

public class Code5 {
    // 다항함수 - 다항함수는 항들의 함이며, 항은 계수와 지수에 의해서 정의된다. 계수는 0이 아닌 정수이고 지수는 움사가 아닌 정수라고 가정한다. ex) f{ }

    static Polynomial [] polys = new Polynomial[100];
    static int n = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("$ ");
            String command = input.next();

            if(command.equals("create")) {
                char name = input.next().charAt(0); // Scanner에는 Char를 입력받는 명령어가 없기에 문자열로 받아서 첫번째 글자만 가져온다.
                polys[n] = new Polynomial();
                polys[n].terms = new Term[100];
                polys[n].name = name;

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
                    addTerm(polys[index], c, e);
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
                    int result = calcPolynimal(polys[index], x);
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
                    printPolynomial(polys[index]);
                }
            }
            else if (command.equals("exit")) {
                break;
            }
        }
        input.close();
    }

    private static int calcPolynimal(Polynomial poly, int x) {
        int result = 0;
        for (int i = 0; i < poly.nTerms; i++) {
            result += caclTerm(poly.terms[i], x);
        }
        return result;
    }

    private static int caclTerm(Term term, int x) {
        return (int) (term.coef * Math.pow(x, term.expo));
    }

    private static void printPolynomial(Polynomial poly) {
        for (int i = 0; i < poly.nTerms; i++) {
            printTerm (poly.terms[i]);
            System.out.println("+");
        }
    }

    private static void printTerm(Term term) {
        System.out.print(term.coef + "x^" + term.expo);
    }

    private static void addTerm(Polynomial poly, int c, int e) {
        int index = findTerm(poly, e);
        if(index != -1) {
            poly.terms[index].coef += c;
        }
        else {
            int i = poly.nTerms-1;
            while (i >= 0 && poly.terms[i].expo < e) {
                poly.terms[i+1] = poly.terms[i];
                i--;
            }
            poly.terms[i+1] = new Term();
            poly.terms[i+1].coef = c;
            poly.terms[i+1].expo = e;
            poly.nTerms++;
        }
    }

    private static int findTerm(Polynomial poly, int e) {
        for (int i = 0; i < poly.nTerms && poly.terms[i].expo >= e; i++) {
            if(poly.terms[i].expo == e) {
                return i;
            }
        }
        return -1;
    }


    private static int find(char name) {
        for (int i = 0; i < n; i++) {
            if (polys[i].name == name) {
                return i;
            }
        }
        return -1;
    }
}
