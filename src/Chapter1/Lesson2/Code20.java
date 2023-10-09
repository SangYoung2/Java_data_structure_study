package Chapter1.Lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Code20 {
    static int n;
    static int [][] grid;

    public static void main(String[] args) {
        // 2차원 배열에서 소수 찾기
        // 입력으로 n*n개의 음이 아닌 정수를 입력하여, 이 정수들 중 가로, 세로, 대각선의 8방향으로 연속된 숫자들을 합쳐서 만들 수 있는 모든 소수를 찾아서 나열하는 프로그램을 작성 (중복된 수를 출력해도 상관없다.)
        // 하나의 수열은 (시작점, 방향, 길이)에 의해서 정의 된다.
        try{
            Scanner inFile = new Scanner(new File("H:\\코리아IT\\Spring_boot\\Java_data_structure_study\\src\\data.txt"));
           n = inFile.nextInt();
           grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = inFile.nextInt();
                }
            }
            inFile.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int dir = 0; dir < 8; dir++) {
                    for (int length = 1; length <= n; length++) {
                        int value = computeValue(x,y,dir,length);
                        if(value != -1 && isPrime(value)) { // dir방향으로 길이가 length인 수열을 정수로 환산하여 반환, 수열이 존재하지 않으면 -1을 반환
                            System.out.println(value);
                        }
                    }
                }
            }
            
        }
    }
    
    static int computeValue(int x, int y, int dir, int len) {
        int value = 0;
        for (int i = 0; i < len; i++) {
            int digit = getDigit(x, y, dir, i); // 시작위치에서 dir방향으로 i칸 떨어진 자리에 있는 digit를 반환, 만약 없으면 -1로 반환
            if(digit == -1) {
                return -1;
            }
            value = value * 10 + digit;
        }
        return value;
    }

    static int getDigit(int x, int y, int dir, int k) {
        int [] offsetX = {0, 1, 1, 1, 0, -1, -1, -1};
        int [] offsetY = {-1, -1, 0, 1, 1, 1, 0, -1};

        int newX = x + k * offsetX[dir];
        int newY = y + k * offsetY[dir];
        if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid.length) {
            return -1;
        }
        return grid[newX][newY];
    }

    static boolean isPrime(int k) {
        if(k < 2) {
            return false;
        }
        for (int i = 2; i*i < k; i++) {
            if(k % i == 0) {
                return false;
            }
        }
        return true;
    }

}
