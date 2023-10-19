package Chapter2.section2;

public class Polynomial2 {
    public char name; // 다항식의 이름
    public int nTerms = 0; // 다항식을 구성하는 항의 갯수
    public Term2[] terms; // 항의 배열

    int calcPolynomial(int x) {
        int result = 0;
        for (int i = 0; i < nTerms; i++) {
            result += terms[i].calcTerm(x);
        }
        return result;
    }

    void printPolynomial(){
        System.out.println(".");
    }
}
