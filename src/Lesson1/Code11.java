package Lesson1;

import java.util.Scanner;

public class Code11 {
    public static void main(String[] args) {
        // n개의 음이 아닌 한 자리 정수를 입력받아 배열에 저장한다. 이들중에서 1개 이상의 연속된 정수들을 합하여 얻을 수 있는 소수들 중에서 최대값을 구하여 출력하는 프로그램을 작성하라
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter array length : ");
        int n = input.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Please enter array [" + i + "] = ");
            data[i] = input.nextInt();
        }
        input.close();

        int maxPrime = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int val = 0;
                for (int k = i; k <= j ; k++) {
                    val = val * 10 + data[k];

                    boolean isPrime = true;
                    for (int l = 2; l < val/2 && isPrime; l++) {
                        if(val % l == 0) {
                            isPrime = false;
                        }
                    }
                    if(isPrime && val > 1 && val > maxPrime) {
                        maxPrime = val;
                    }
                }
            }
        }

        if(maxPrime > 0) {
            System.out.println("The max prime number is " + maxPrime);
        }
        else {
            System.out.println("No prime number exists.");
        }

    }
}
