package Chapter1.Section1;

import java.util.Scanner;

public class Code6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter array length : ");
        int n = input.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Please enter array [" + i + "] = ");
            data[i] = input.nextInt();
        }
        input.close();

        int sum = 0, max = data[0]; // max값을 0으로 지정할 경우 음수값이 입력 될 경우 오류가 발생하여 data의 첫번째 값을 넣어준다.
        for (int i = 0; i < n; i++) {
            sum += data[i];
            if(data[i] > max) max = data[i];
        }
        System.out.println("The sum is " + sum + " and the maximum is " + max);
    }
}
