package Chapter1.Lesson1;

import java.util.Scanner;

public class Code13 {
    public static void main(String[] args) {
        // 사용자로부터 n개의 정수를 입력받는다. 정수가 하나 씩 입력될 때 마다 현재까지 입력된 정수들을 오름차순으로 정렬하여 출력하라.
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter array length : ");
        int n = input.nextInt();
        int[] data = new int[n];

        // 새로운 값을 입력 할 때 마다 뒤에서 부터 비교하여 오름차순으로 정렬한다.
        for (int i = 0; i < n; i++) {
            System.out.print("Please enter array [" + i + "] = ");
            int tmp = input.nextInt();
            int j = i - 1;
            while (j >= 0 && data[j] > tmp) {
                data[j+1] = data[j];
                j--;
            }
            data[j+1] = tmp;

            for (int k = 0; k <= i ; k++) {
                System.out.print(data[k] + " ");
            }
            System.out.println();
        }
        input.close();
    }
}
