package Lesson1;

import java.util.Scanner;

public class Code7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter array length : ");
        int n = input.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Please enter array [" + (i+1) + "] = ");
            data[i] = input.nextInt();
        }
        input.close();

        // 배열 내 값들을 모두 오른쪽으로 한칸 씩 이동 시키는 반복문
        int tmp = data[n-1]; // 배역의 마지막 값을 tmp에 저장
        for (int i = n-2; i >= 0 ; i--) {
            data[i+1] = data[i]; // 배열의 끝에서 2번째 값 부터 한칸 씩 오른쪽으로 이동시킨다.
        }
        data[0] = tmp; // 배열 맨 앞에 값을 tmp에 저장했던 값을 넣어준다.

        for (int i = 0; i < n; i++) {
            System.out.println("new array [" + (i+1) + "] = " + data[i]);
        }
    }
}
