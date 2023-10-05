package Chapter1.Lesson1;

public class Code8 {
    public static void main(String[] args) {
        // 1~100000 사이의 모든 소수들을 찾아서 출력하는 프로그램 (소수 : 1과 자기자신만을 약수로 가지는 수)

        for (int i = 2; i <= 100000 ; i++) {
            boolean isPrime = true;
            for (int j = 2; j*j <= i && isPrime ; j++) {
                if(i % j == 0) { // 하나라도 약수가 있다면 더 이상 검사할 필요가 없음
                    isPrime = false;
                }
            }
            if(isPrime) {
                System.out.println("소수 : " + i);
            }
        }
    }
}
