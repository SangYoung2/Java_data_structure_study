package Summary;

import java.util.Scanner;

public class Code1 {

    // 전역 번수로 사용 할 시 static이 없으면 다른 곳에서 사용 할 수가 없다.
    static String [] names = new String[1000];
    static int []  numbers = new int[1000];
    static int n = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();               // scanf("%d, &k"); 와 같음 정수를 k에 대입

        for (int i = 0; i < k; i++) {
            names[i] = sc.next();           // scanf("%s", ...)
            numbers[i] = sc.nextInt();
        }

        sc.close();

        for (int i = 0; i < k; i++) {
            System.out.println("Name: " + names[i] + ", Number: " + numbers[i]);
        }

    }
}
