package Chapter1.Lesson1;

import java.util.Scanner;

public class Code12 {
    public static void main(String[] args) {
        // 사용자로부터 n개의 정수를 입력받은 후 오름차순으로 정렬(sort)하여 출력하는 코드 - 버블정렬
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter array length : ");
        int n = input.nextInt();
        int[] data = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Please enter array [" + i + "] = ");
            data[i] = input.nextInt();
        }
        input.close();

        // bubble sort (버블 정렬 알고리즘)
        for (int i = n-1; i > 0; i--) {
            // data[0] ~ data[i] 까지 각각의 값을 다음 값과 비교하여 가장 큰 값을 i값의 위치로 이동시킨다.
            for (int j = 0; j < i; j++) {
                if(data[j] > data[j+1]) { //data[j]와 data[j+1]을 비교
                    // data[j] 와 data[j+1] 값의 위치 변경
                    int tmp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = tmp;
                }
            }
        }

        System.out.print("Sorted data : ");
        for (int i = 0; i < n; i++) {
            System.out.print(data[i] + ", ");
        }
    }
}
