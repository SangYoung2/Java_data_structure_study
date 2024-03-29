package Chapter1.Section1;

import java.util.Scanner;

public class Code10 {
    public static void main(String[] args) {
        // n개의 정수를 입력받아 배열에 저장한다. 이들 중에서 0개 이상의 연속된 정수들을 더하여 얻을 수 있는 최대값을 구하여 출력하는 프로그램을 작성하라
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter array length : ");
        int n = input.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Please enter array [" + i + "] = ");
            data[i] = input.nextInt();
        }
        input.close();

        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += data[j];
                if (sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        System.out.println("The max sum is " + maxSum);

    }
}
