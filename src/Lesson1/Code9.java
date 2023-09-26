package Lesson1;

import java.util.Scanner;

public class Code9 {
    public static void main(String[] args) {
        // 중복된 정수쌍의 개수를 카운트 하여 출력
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter array length : ");
        int n = input.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Please enter array [" + (i+1) + "] = ");
            data[i] = input.nextInt();
        }
        input.close();
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(data[i] == data[j]){
                    count++;
                }
            }
        }
        System.out.println("Count = " + count);
    }
}
