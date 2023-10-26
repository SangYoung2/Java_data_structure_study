package Chapter2.section3;

public class Term3 {
    // 메서드 또한 관련있는 정보들을 모아두는 class에 모아두면 응집도는 높이면서 결합도는 낮출 수 있다.
    // Term2객체의 정적 속성 (데이터)
    private int coef; // 계수

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    private int expo; // 지수

    public Term3(int coef, int expo) { // 생성자
        this.coef = coef;
        this.expo = expo;
    }

    // Term2객체의 동적 속성 (객체가 제공하는 기능)
    int calcTerm(int x) { // pow로 값을 구하면 double의 형태가 되기 때문에 (int)를 사용하여 int로 바꾸어서 return한다.
        return (int) (coef * Math.pow(x, expo));
    }
    void printTerm() {
        System.out.println(coef + "x^" + expo);
    }
}
